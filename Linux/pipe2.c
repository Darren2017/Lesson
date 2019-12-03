/*************************************************************************
	> File Name: pipe2.c
	> Author: 
	> Mail: 
	> Created Time: 一  5/27 20:07:37 2019
 ************************************************************************/

#include<stdio.h>
#include <sys/types.h>
#include <unistd.h>
#include <stdlib.h>
#include <time.h>

int main()
{
    srand((unsigned)time(0));
    int guess_num = rand();
    pid_t pid;
    if((pid = fork()) > 0){
        printf("error in fork\n");
    }
    while(pid != guess_num){ 
        printf("父进程说：%d\n", guess_num);
        if(pid > guess_num){
            printf("子进程说：小了\n");
            guess_num += (rand() % 1200); 
//            guess_num += (rand() % (pid - guess_num));
        }else{
            printf("子进程说：大了\n");
            guess_num -= (rand() % 1200);
//            guess_num -= (rand() % (guess_num - pid));
        }
    }
    printf("猜对了%d\n", pid);

    return 0;
}
