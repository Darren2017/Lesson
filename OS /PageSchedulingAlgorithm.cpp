#include <iostream>
#include <vector>
#include <queue>
#define SIZE 3
using namespace std;

typedef struct Page {
  int page;
  int cnt;
} Page;

void FIFO(vector<int> list, int n);
void LRU(vector<int> list, int n);
void OPT(vector<int> list, int n);
void show(vector<int> list);

void FIFO(vector<int> list, int n) {
    cout << "FIFO" << endl;
    vector<int> q;
    int fail = 0;
    int i;

    for (i = 0; i < n; i++) {
        bool flag = false;
        for (int j = 0; j < q.size(); j++) {
            if (q[j] == list[i]) {
                flag = true;
            }
            if (flag) {
                break;
            }
        }

        if (flag) {
            cout << "访问" << list[i] << "页面成功" << endl;
        }else {
            cout << "访问" << list[i] << "页面失败" << endl;
            if (q.size() >= SIZE) {
                cout << "淘汰" << q.front() << "页面" << endl;
                q.erase(q.begin());
            }
            q.push_back(list[i]);
            fail++;
        }
    }
    cout << "缺页总次数为:" << fail << " " << "缺页中断率为：" << float(fail) / float(n) << endl; 
}
bool cmp(Page a, Page b) {
    return a.cnt < b.cnt;
}

void OPT(vector<int> list, int n){
    cout << "OPT" << endl;
    vector<Page> q;
    int i, k = 0;
    int fail = 0;

    for(i = 0; i < n; i++){
        bool flag = false;
        if(!q.empty()){
            for(int j = 0; j < q.size(); j++){
                if(q[j].page == list[i]){
                    flag = true;
                }
                if(flag){
                    break;
                }
            }
        }
        if(flag){
            cout << "访问" << list[i] << "页面成功" << endl;
            k++;
        }else{
            cout << "访问" << list[i] << "页面失败" << endl;
            for(int j = 0; j < q.size(); j++){
                q[j].cnt = 0;
                for(int m = k; m < n; m++){
                    if(q[j].page == list[m]){
                        break;
                    }else{
                        q[j].cnt++;
                    }
                }
            }
            sort(q.begin(), q.end(), cmp);
            if (q.size() >= SIZE) {
                cout << "淘汰" << q[2].page << "页面" << endl;
                q.erase(q.begin() + 2);
            }
            Page p;
            p.page = list[i];
            q.push_back(p);
            fail++;
            k++;
        }
    }
    cout << "缺页总次数为:" << fail << " " << "缺页中断率为：" << float(fail) / float(n) << endl; 
}

void LRU(vector<int> list, int n) {
    cout << "LRU" << endl;
    vector<Page> q;
    int i;
    int fail = 0;

    for (i = 0; i < n; i++) {
        bool flag = false;
        if (!q.empty()) {
            for (int j = 0; j < q.size(); j++) {
                if (q[j].page == list[i]) {
                    flag = true;
                    q[j].cnt++;
                    sort(q.begin(), q.end(), cmp);
                }
                if (flag) {
                    break;
                }
            }
        }
        
        if (flag) {
            cout << "访问" << list[i] << "页面成功" << endl;
        } else {
            cout << "访问" << list[i] << "页面失败" << endl;
            if (q.size() >= SIZE) {
                cout << "淘汰" << q.front().page << "页面" << endl;
                q.erase(q.begin());
            }
            Page p;
            p.page = list[i];
            p.cnt = 1;

            q.push_back(p);
            fail++;
            sort(q.begin(), q.end(), cmp);
        }
    }
    cout << "缺页总次数为:" << fail << " " << "缺页中断率为：" << float(fail) / float(n) << endl; 
}
void show(vector<int> list) {
    cout << "缓存序列为： ";
    for (int i = 0; i < list.size(); i++) {
        cout << list[i] << " ";
    }
    cout << endl;
}

int main() {
    cout << "请输入页面请求序列长度:" ;
    int n;
    cin >> n;
    vector<int> input(n);
    cout << "请输入页面请求序列:" ;
    for (int i = 0; i < n; i++) {
        cin >> input[i];
    }
    FIFO(input, n);
    cout << "---------------------------" << endl;
    LRU(input, n);
    cout << "---------------------------" << endl;
    OPT(input, n);

    return 0;
}