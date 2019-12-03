#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>
#include<iomanip>

using namespace std;

enum Status{ready, waiting, run};

class Process{
    public:
        int id;
        Status status;
        int rt;             //运行时间
        int priority;       //优先级
        int at;             //到达时间
        int wt;             //等待时间
        int ave_wt;         //平均等待时间
        int hr;              //已经运行时间
        bool visited;

        Process(int id, int at, int rt, int priority){
            this -> id = id;
            this -> at = at;
            this -> rt = rt;
            this -> priority = priority;
            this -> wt = 0;
            this -> ave_wt = 0;
            this -> status = ready;
            this -> visited = false;
            this -> hr = 0;
        }

        bool operator < (const Process &a) const{
           return a.priority < priority;
        }
};

struct cmp_p{

    bool operator ()(const Process* a, const Process* b)
    {
        return a -> priority > b -> priority;// 按照value从小到大排列
    }
};

void clear(int n, vector<Process*> p);
bool cmp_at(Process* a, Process* b);
void FIFO(int n, vector<Process*> p);
void highPriority_non_preemptive(int n, vector<Process*> p);
void highPriority_preemptive(int n, vector<Process*> p);
void RR(int n, vector<Process*> p);
void FB(int n, vector<Process*> p);

int main()
{
    vector<Process*> p(10);
    int n;
    cout << "Please input the number of process: ";
    cin >> n;
    int id, at, rt, priority;
    cout << "输入作业的信息：进程号 到达时间 运行时间 优先数（0最高）" << endl;
    for(int i = 0; i < n; i++){
        cin >> id >> at >> rt >> priority;
        p[i] = new Process(id, at, rt, priority);
    }
    sort(p.begin(), p.begin() + n, cmp_at);
    cout << "FIFO:" << endl;
    FIFO(n,p);
    cout << "--------------------------------" << endl;
    cout << "highPriority_non_preemptive:" << endl;
    highPriority_non_preemptive(n,p);
    cout << "--------------------------------" << endl;
    cout << "highPriority_preemptive:" << endl;
    highPriority_preemptive(n,p);
    cout << "--------------------------------" << endl;
    cout << "RR:" << endl;
    RR(n,p);
    cout << "--------------------------------" << endl;
}

int calc_ti_di(int at1, int at2){
    int ah = at1 / 100;
    int am = at1 - ah * 100;
    int bh = at2 / 100;
    int bm = at2 - bh * 100;
    return (bh - ah) * 60 + (bm - am);
}

bool cmp_at(Process* a, Process* b){
    return a -> at <= b -> at;
}

void FIFO(int n, vector<Process*> p){
    clear(n, p);
    int sum_wt = 0;
    p[0] -> wt = 0;
    for(int i = 1; i < n; i++){
        int temp = p[i - 1] -> wt + p[i - 1] -> rt - calc_ti_di(p[i - 1] -> at, p[i] -> at);
        p[i] -> wt = temp > 0 ? temp : 0;
    }

    cout << "进程号   等待时间" << endl;
    for (int i = 0; i < n; i++) {
        sum_wt += p[i] -> wt;
        cout << setw(3) << p[i] -> id << setw(9) << p[i] -> wt << endl;
    }
    cout << "平均等待时间：" << setw(5) << float(sum_wt) / float(n) << endl;
}

int calc_now_Time(int nt, int rt) {
    int nowMinute = nt % 100;
    int nowHour = nt / 100;
    int newMinutue = nowMinute;
    if (rt + nowMinute >= 60) {
        nowHour += 1;
    }
    newMinutue = (rt + nowMinute) % 60;
    return nowHour * 100 + newMinutue;
}

int calc_pre_Time(int nt, int t) {
    int nowMinute = nt % 100;
    int nowHour = nt / 100;
    // int newMinutue = nowMinute;
    nowHour -= t / 60;
    t %= 60;
    if (nowMinute - t < 60) {
        nowHour -= 1;
    }
    int newMinutue = nowMinute + 60 - t;;
    return nowHour * 100 + newMinutue;
}

void highPriority_non_preemptive(int n, vector<Process*> p){
    vector<int> order(100);
    clear(n, p);
    priority_queue<Process*, vector<Process*>, cmp_p> wait_process;
    Process* cur_process;
    int nt = p[0] -> at;
    int sum_wt = 0;
    wait_process.push(p[0]);
    p[0] -> visited = true;

    cout << "进程号   等待时间" << endl;
    while(!wait_process.empty()){
        cur_process = wait_process.top();
        order.push_back(cur_process -> id);
        wait_process.pop();
        nt = calc_now_Time(nt, cur_process -> rt);
        cur_process -> wt = calc_ti_di(cur_process -> at, calc_pre_Time(nt, cur_process -> rt));
        cout << setw(3) << cur_process -> id << setw(9) << cur_process -> wt << endl;
        sum_wt += (cur_process -> wt);

        for(int i = 0; i < n; i++){
            if(p[i] -> at <= nt && !p[i] -> visited){
                wait_process.push(p[i]);
                p[i] -> visited = true;
            }
        }
        if(wait_process.empty()){
            for(int i = 0; i < n; i++){
                if(p[i] -> at >= nt && !p[i] -> visited){
                    wait_process.push(p[i]);
                    p[i] -> visited = true;
                    nt = p[i] -> at;
                    break;
                }
            }
        }
    }
    cout << "平均等待时间：" << setw(5) << float(sum_wt) / float(n) << endl; 
    cout << "调度序列: ";
    for(int i : order){
        if(i != 0){
            cout << i << "  ";
        }
    }
    cout << endl;
}

void highPriority_preemptive(int n, vector<Process*> p){
    clear(n, p);
    vector<int> order(100000, 0);
    priority_queue<Process*, vector<Process*>, cmp_p> wait_process;
    int sum_wt = 0;
    Process* cur_process;
    int nt = p[0] -> at;
    int ft = nt;
    p[0] -> status = run;
    p[0] -> visited = true;
    wait_process.push(p[0]);
    order.push_back(p[0] -> id);

    cout << "进程号   等待时间" << endl;
    while(!wait_process.empty()){
        cur_process = wait_process.top();
        wait_process.pop();
        if(cur_process -> id != order.back()){
            order.push_back(cur_process -> id);
        }

        ft = calc_now_Time(nt, (cur_process -> rt) - (cur_process -> hr));
        for(int j = nt; j < ft; j = calc_now_Time(j, 1)){
            for(int i = 0; i < n; i++){
                if(!(p[i] -> visited) && (p[i] -> at) < j){
                    p[i] -> visited = true;
                    wait_process.push(p[i]);
                }
            }

            if(!wait_process.empty()){
                if(wait_process.top() -> priority < cur_process -> priority){
                    wait_process.push(cur_process);
                    cur_process = wait_process.top();
                    // cout << "----" << cur_process -> id << endl;
                    if(cur_process -> id != order.back()){
                        order.push_back(cur_process -> id);
                    }
                    wait_process.pop();
                    ft = calc_now_Time(nt, (cur_process -> rt) - (cur_process -> hr));
                    continue;
                }
            }
            (cur_process -> hr)++;
            nt = j;
        }
        nt = ft;
        cur_process -> wt = calc_ti_di(cur_process -> at, nt) - (cur_process -> rt);
        sum_wt += cur_process -> wt;
        cout << setw(3) << cur_process -> id << setw(9) << cur_process -> wt << endl;
        
        if(wait_process.empty()){
            for(int i = 0; i < n; i++){
                if(p[i] -> at >= nt && !p[i] -> visited){
                    wait_process.push(p[i]);
                    p[i] -> visited = true;
                    nt = p[i] -> at;
                    break;
                }
            }
        }
    }
    if(cur_process -> id != order.back()){
        order.push_back(cur_process -> id);
    }
    cout << "平均等待时间：" << setw(5) << float(sum_wt) / float(n) << endl; 
    cout << "调度序列: ";
    for(int i : order){
        if(i != 0){
            cout << i << "  ";
        }
    }
    cout << endl;
}

void RR(int n, vector<Process*> p){
    clear(n, p);
    vector<int> order(100, 0);
    int Q = 20;
    vector<Process*> wait_process;
    int sum_wt = 0;
    wait_process.push_back(p[0]);
    p[0] -> visited = true;
    int nt = p[0] -> at;

    cout << "进程号   等待时间" << endl;

    while(!wait_process.empty()){
        Process* cur_process = wait_process.front();
        if(cur_process -> id != order.back()){
            order.push_back(cur_process -> id);
        }
        wait_process.erase(wait_process.begin());
        int wt = 0;
        if(cur_process -> rt - cur_process -> hr >= Q){
            cur_process -> hr += Q;
            wt = Q;
            nt = calc_now_Time(nt, wt);
        }else{
            wt = cur_process -> rt - cur_process -> hr;
            nt = calc_now_Time(nt, wt);
            cur_process -> hr = cur_process -> rt;
        }
        for(int i = 0; i < n; i++){
            if(p[i] -> at <= nt && !p[i] -> visited){
                p[i] -> visited = true;
                wait_process.push_back(p[i]);
            }
        }
        if(cur_process -> hr < cur_process -> rt){
            wait_process.push_back(cur_process);
        }else{
            cur_process -> wt = calc_ti_di(cur_process -> at, nt) - cur_process -> rt;
            sum_wt += cur_process -> wt;
            cout << setw(3) << cur_process -> id << setw(9) << cur_process -> wt << endl;
        }
    }
    cout << "平均等待时间：" << setw(5) << float(sum_wt) / float(n) << endl; 
    cout << "调度序列: ";
    for(int i : order){
        if(i != 0){
            cout << i << "  ";
        }
    }
    cout << endl;
}

/*
测试用例：
7
1 800 50 4
2 815 30 3
3 830 2 5
4 835 20 2
5 845 15 0
6 900 10 1
7 920 5 3
*/





























































void FB(int n, vector<Process*> p){
    clear(n, p);
    vector<Process*> q1;
    vector<Process*> q2;
    vector<Process*> q3;
    vector<int> order(100, 0);

    int p1 = 5, p2 = 10, p3 = 15;
    int nt = p[0] -> at;
    int sum_wt = 0;
    Process* cur_process;

    p[0] -> visited = true;
    q1.push_back(p[0]);

    cout << "进程号   等待时间" << endl;
    while(!q1.empty() || !q2.empty() || !q3.empty()){
        int ft = nt;
        if(!q1.empty()){
            cur_process = q1.front();
            q1.erase(q1.begin());

            if(cur_process -> rt - cur_process -> hr > p1){
                cur_process -> hr += p1;
                nt = calc_now_Time(nt, p1);
            }else{
                nt = calc_now_Time(nt, cur_process -> rt - cur_process -> hr);
                cur_process -> hr = cur_process -> rt;
            }

            for(int i = 0; i < n; i++){
                if(!p[i] -> visited && p[i] -> at <= nt){
                    p[i] -> visited = true;
                    q1.push_back(p[i]);
                }
            }
            if(cur_process -> hr < cur_process -> rt){
                q2.push_back(cur_process);
            }else{
                cur_process -> wt = calc_ti_di(cur_process -> at, nt) - cur_process -> rt;
                sum_wt += cur_process -> wt;
                cout << setw(3) << cur_process -> id << setw(9) << cur_process -> wt << endl;
            }
        }
        if(q1.empty() && !q2.empty()){
            cur_process = q2.front();
            q2.erase(q2.begin());

            int phr = cur_process -> hr;
            if(cur_process -> rt - cur_process -> hr > p2){
                cur_process -> hr += p2;
                ft = calc_now_Time(nt, p2);
            }else{
                ft = calc_now_Time(nt, cur_process -> rt - cur_process -> hr);
                cur_process -> hr = cur_process -> rt;
            }
            for(int i = 0; i < n; i++){
                if(!p[i] -> visited && p[i] -> at <= nt){
                    p[i] -> visited = true;
                    q1.push_back(p[i]);
                }
            }

            if(!q1.empty()){
                if(cur_process -> hr < cur_process ->rt){
                    cur_process -> hr = phr + calc_ti_di(nt, q1.front() -> at);
                }
                nt = q1.front() -> at;
                q2.push_back(cur_process);
                continue;
            }else{
                nt = ft;
            }
            
            if(cur_process -> hr < cur_process -> rt){
                q3.push_back(cur_process);
            }else{
                cur_process -> wt = calc_ti_di(cur_process -> at, nt) - cur_process -> rt;
                sum_wt += cur_process -> wt;
                cout << setw(3) << cur_process -> id << setw(9) << cur_process -> wt << endl;
            }
        }
        if(q1.empty() && q2.empty() && !q3.empty()){
            cur_process = q3.front();
            q3.erase(q3.begin());

            int phr = cur_process -> hr;
            if(cur_process -> rt - cur_process -> hr >= p3){
                cur_process -> hr += p3;
                ft = calc_now_Time(nt, p3);
            }else{
                ft = calc_now_Time(nt, cur_process -> rt - cur_process -> hr);
                cur_process -> hr = cur_process -> rt;
            }

            for(int i = 0; i < n; i++){
                if(!p[i] -> visited && p[i] -> at <= nt){
                    p[i] -> visited = true;
                    q1.push_back(p[i]);
                }
            }
            if(!q1.empty()){
                if(cur_process -> hr < cur_process -> rt){
                    cur_process -> hr = phr + calc_ti_di(nt, q1.front() -> at);
                }
                nt = q1.front() -> at;
                q3.push_back(cur_process);
                continue;
            }else{
                nt = ft;
            }

            if(cur_process -> hr < cur_process -> rt){
                q3.push_back(cur_process);
            }else{
                cur_process -> wt = calc_now_Time(cur_process -> at, nt) - cur_process -> rt;
                sum_wt += cur_process -> wt;
                cout << setw(3) << cur_process -> id << setw(9) << cur_process -> wt << endl;
            }
        }
    }
    cout << "平均等待时间：" << setw(5) << float(sum_wt) / float(n) << endl; 
    cout << "调度序列: ";
    for(int i : order){
        if(i != 0){
            cout << i << "  ";
        }
    }
    cout << endl;
}

void clear(int n, vector<Process*> p){
    for(int i = 0; i < n; i++){
            p[i] -> wt = 0;
            p[i]  -> ave_wt = 0;
            p[i]  -> status = ready;
            p[i]  -> visited = false;
            p[i]  -> hr = 0;
    }
}

/*
测试用例：
7
1 800 50 4
2 815 30 3
3 830 2 5
4 835 20 2
5 845 15  0
6 900 10 1
7 920 5 3
*/