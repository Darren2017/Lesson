#include<iostream>
#include<vector>
#include<algorithm>
#include<iomanip>
#include<queue>

using namespace std;

typedef struct job {
	int jid;
	int at;
	int bt;
	int wt;
	double r;
	bool visited;
	bool operator < (const job &a) const{
		return a.bt < bt;
	}
} job;

void FIFO(int n, vector<job> p);        //FIFO
void SJF(int n, vector<job> p);         //短作业优先
void HRRN(int n, vector<job> p);        //响应比最高者优先调度
bool cpAt(job a, job b);                //比较到达时间

int main(){
	int n;
	cout << "请输入作业数量：";
	cin >> n;
	vector<job> p(n);

	cout << "输入作业的信息：作业号 到达时间 运行时间" << endl;
	for (int i = 0; i < n; i++) {
		cin >> p[i].jid >> p[i].at >> p[i].bt;
		p[i].wt = 0;
		p[i].r = 0.0;
		p[i].visited = false;
	}

	cout << "FIFO:" << endl;
	FIFO(n, p);
	cout << "------------------" << endl;
	cout << "SJF:" << endl;
	SJF(n, p);
	cout << "------------------" << endl;
	cout << "HRRN:" << endl;
	HRRN(n, p);

	return 0;
}

bool cpAt(job a, job b) {
	return (a.at <= b.at);
}

int calculate(int a, int b){
	int a_h = a / 100;
	int a_m = a - a_h * 100;
	int b_h = b / 100;
	int b_m = b - b_h * 100;

	int m = b_m - a_m;
	int h = b_h - a_h;
	return h * 60 + m;
}

void FIFO(int n, vector<job> p) {
	sort(p.begin(), p.end(), cpAt);
	p[0].wt = 0;
	for (int i = 1; i < n; i++) {
		int wait = p[i - 1].wt + p[i].bt - calculate(p[i - 1].at, p[i].at);
		p[i].wt = wait > 0 ? wait : 0;
	}

	cout << "进程号  进入时间 运行时间  等待时间" << endl;
	for (int i = 0; i < n; i++) {
		cout << setw(3) << p[i].jid << setw(9) << p[i].at << setw(9) << p[i].bt << setw(9) << p[i].wt << endl;
	}
}

int calcTime(int nt, int bt) {
	int nowMinute = nt % 100;
	int nowHour = nt / 100;
	int newMinutue = nowMinute;
	if (bt + nowMinute >= 60) {
		nowHour += 1;
	}
	newMinutue = (bt + nowMinute) % 60;
	return nowHour * 100 + newMinutue;
}

void SJF(int n, vector<job> p) {
	sort(p.begin(), p.end(), cpAt);
	priority_queue<job> wait_job;
	job curRun;
	int nowtime = p[0].at;
	wait_job.push(p[0]);
	p[0].visited = true;

	cout << "进程号  进入时间 运行时间  结束运行时间" << endl;

	while (!wait_job.empty()) {
		curRun = wait_job.top();
		wait_job.pop();
		nowtime = calcTime(nowtime, curRun.bt);

		cout << setw(3) << curRun.jid << setw(9) << curRun.at << setw(9) << curRun.bt << setw(9) << nowtime <<endl;
		for (int i = 0; i < n; i++) {
			if (p[i].at <= nowtime && !p[i].visited){
				wait_job.push(p[i]);
				p[i].visited = true;
			}
		}

		if(wait_job.empty()) {
			for(int i = 0; i < n; i++) {
				if (p[i].at >= nowtime && !p[i].visited) {
					wait_job.push(p[i]);
					p[i].visited = true;
					nowtime = p[i].at;
					break;
				}
			}
		}
	}
}

bool cpRR(job a, job b){
	return (a.r < b.r);
}

void HRRN(int n, vector<job> p){
	sort(p.begin(), p.end(), cpAt);
	vector<job> wait_jobs;
	job curRun;
	int nowtime = p[0].at;
	p[0].visited = true;
	wait_jobs.push_back(p[0]);

	cout << "进程号  进入时间  运行时间  结束运行时间" << endl;

	while (!wait_jobs.empty()) {
		for (int i = 0; i < wait_jobs.size(); i++) {
			wait_jobs[i].wt = calculate(wait_jobs[i].at, nowtime);
			wait_jobs[i].r = double((wait_jobs[i].wt + wait_jobs[i].bt))/ double(wait_jobs[i].bt);
		}
		sort(wait_jobs.begin(), wait_jobs.end(), cpRR);
		curRun = wait_jobs.back();
		wait_jobs.pop_back();
		nowtime = calcTime(nowtime, curRun.bt);

		cout << setw(3) << curRun.jid << setw(9) << curRun.at << setw(9) << curRun.bt << setw(9) << nowtime <<endl;

		for (int i = 0; i < n; i++) {
			if (p[i].at <= nowtime && !p[i].visited) {
				p[i].visited = true;
				wait_jobs.push_back(p[i]);
			}
		}

		if(wait_jobs.empty()) {
			for (int i = 0; i < n; i++) {
				if (p[i].at >= nowtime && !p[i].visited) {
					p[i].visited = true;
					wait_jobs.push_back(p[i]);
					nowtime = p[i].at;
					break;
				}
			}
		}
	}
}
