#include<stdio.h>
#include"h2.h"
#include"h1.h"


void p2_print(){
    printf("在p2_print函数中调用：");
    func1();
}

void func2(){
    printf("调用func2函数:\n");
}