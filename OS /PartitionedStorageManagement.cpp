#include <iostream>
#include <vector>
#include <iomanip>

using namespace std;

#define M 100
#define N 100
#define MINISIZE 5

typedef struct Table {
    int add;
    int len;
    int flag;   // 空闲表0为已分配，为1则未分配； 内存分配表0为空闲，不为1为作业号
} Table;

typedef struct process {
    int pid;
    int len;
} process;

vector<Table> freeTable(M);
vector<Table> usedTable(N);

void initTable();
int updateTable(int pid, int fitAdd, int needlen);
int BestFit(int pid, int needlen);
int FirstFit(int pid, int needlen);
int WorstFit(int pid, int needlen);
void show();


void initTable() {
    freeTable[0].flag = 1;
    freeTable[0].add = 1000;
    freeTable[0].len = 1024;

    for (int i = 0; i < N; i++) {
        usedTable[i].flag = 0;
    }
}

int BestFit(int pid, int needlen) {
    int fitAdd = -1;
    int i = 0;
    int cnt = 0;

    while (i < M) {
        if (freeTable[i].flag == 1 && freeTable[i].len >= needlen) {
            cnt++;
            if (cnt == 1 || freeTable[fitAdd].len > freeTable[i].len) {
                fitAdd = i;
            }
        }
        i++;
    }
    return updateTable(pid, fitAdd, needlen);
}

int FirstFit(int pid, int needlen) {
    int fitAdd = -1;
    int i = 0;
    while (i < M) {
        if (freeTable[i].flag == 1 && freeTable[i].len >= needlen) {
            fitAdd = i;
        }
        i++;
    }
    i = 0;
    while (i < M) {
        if (freeTable[i].flag == 1 && freeTable[i].len >= needlen && freeTable[i].add < freeTable[fitAdd].add) {
            fitAdd = i;
        }
        i++;
    }
    return updateTable(pid, fitAdd, needlen);
}

int WorstFit(int pid, int needlen) {
    int fitAdd = -1;
    int i = 0;
    int cnt = 0;
    while (i < M) {
    if (freeTable[i].flag == 1 && freeTable[i].len >= needlen) {
        cnt++;
        if (cnt == 1 || freeTable[fitAdd].len < freeTable[i].len ) {
            fitAdd = i;
        }
    }
        i++;
    }
    return updateTable(pid, fitAdd, needlen);
}

int updateTable(int pid, int fitAdd, int needlen) {

    int length = 0;
    int address = 0;

    if (fitAdd != -1) {
        if (freeTable[fitAdd].len - needlen <= MINISIZE) {
            freeTable[fitAdd].flag = 0;
            length = freeTable[fitAdd].len;
            address = freeTable[fitAdd].add;
        } else {
            length = needlen;
            address = freeTable[fitAdd].add;

            freeTable[fitAdd].add += needlen;
            freeTable[fitAdd].len -= needlen;
        }

        int i = 0;
        while ( usedTable[i].flag != 0) {
            i++;
        }
        if (i < N) {
            usedTable[i].flag = pid;
            usedTable[i].add = address;
            usedTable[i].len = length;
        } else {
            if (freeTable[fitAdd].flag == 0) {
                freeTable[fitAdd].flag = 1;
                freeTable[fitAdd].add = address;
                freeTable[fitAdd].len = length;
            } else {
                freeTable[fitAdd].add = address;
                freeTable[fitAdd].len += length;
            }
        }
    } else {
        cout << "找不到适合的空闲分区" << endl;
        return 0;
    }
        return pid;
    }

    int freeMemory(int pid) {
    int id = 0;
    int address, length;
    int i = 0;
    int top = -1, bottom = -1;

    while(id < N && usedTable[id].flag != pid) {
        id++;
    }

    if (id < N) {
        address = usedTable[id].add;
        length = usedTable[id].len;
        usedTable[id].flag = 0;
    } else {
        cout << "该进程不存在" << endl;
    }


    while(!(i >= M || (top != -1 && bottom != -1))) {
        if (freeTable[i].flag == 1) {
            if (freeTable[i].add + freeTable[i].len == address) {
                top = i;
            }
            if (address + length ==  freeTable[i].add ) {
                bottom = i;
            }
        }
        i++;
    }

    if (top != -1) {
        if (bottom != -1) {
            freeTable[top].len += freeTable[bottom].len + length;
            freeTable[bottom].flag = 0;
            freeTable[bottom].len = 0;
        } else {
            freeTable[top].len += length;
        }
    } else if (bottom != -1) {
        freeTable[bottom].len += length;
        freeTable[bottom].add = address;
    } else {
        int j = 0;
        while (freeTable[j].flag != 0) {
            j++;
        }
        if (j <  M) {
            freeTable[j].add = address;
            freeTable[j].len = length;
            freeTable[j].flag = 1;
        } else {
            usedTable[id].flag = pid;
            cout << "空闲区已满，回收失败" << endl;
            return -1;
        }
    }
    return pid;
}

bool compareAddress(Table a, Table b) {
  return a.add < b.add;
}

void show() {
    sort(freeTable.begin(), freeTable.end(), compareAddress);
    cout << "内存分配情况：" << endl;
    for (int i = 0; i < usedTable.size(); i++) {
        if (usedTable[i].flag != 0) {
            cout << "\t地址：" << setw(4) << usedTable[i].add << "  进程号:" << setw(3) << usedTable[i].flag << "  进程空间大小：" << setw(4) <<  usedTable[i].len << endl;
        }
    }
    cout << "空闲区：" << endl;
    for (int j = 0; j < freeTable.size(); j++) {
        if (freeTable[j].flag != 0) {
            cout << "\t地址：" << setw(4) << freeTable[j].add <<  "  进程空间大小：" << setw(4) <<  freeTable[j].len << endl;
        }
    }
    cout <<  endl << endl;
}

int main() {
    int ch;
    int num;
    process p[100];
    cout << "请输入操作次数：" << endl;
    cin >> num;
    cout << "请输入进程序列和所需内存（释放内存输入0即可）:";
    for(int i = 0; i < num; i++){
        cin >> p[i].pid;
        cin >> p[i].len;
    }
    cout << "（1）使用【最佳适配算法】内存申请空间 （2）使用【最差适配算法】内存申请空间 （3）使用【首次适配算法】内存申请空间" << endl;
    cin >> ch;
    switch(ch){
        case 1:{
            initTable();
            for(int i = 0; i < num; i++){
                if(p[i].len){
                    BestFit(p[i].pid, p[i].len);
                    show();
                }else{
                    freeMemory(p[i].pid);
                    show();
                }
            }
            break;
        }
        case 2:{
            initTable();
            for(int i = 0; i < num; i++){
                if(p[i].len){
                    WorstFit(p[i].pid, p[i].len);
                    show();
                }else{
                    freeMemory(p[i].pid);
                    show();
                }
            }
            break;
        }
        case 3:{
            initTable();
            for(int i = 0; i < num; i++){
                if(p[i].len){
                    FirstFit(p[i].pid, p[i].len);
                    show();
                }else{
                    freeMemory(p[i].pid);
                    show();
                }
            }
            break;
        }
    }
    return 0;
}

// 5
// 1 200
// 2 250
// 1 0
// 3 50
// 4 120