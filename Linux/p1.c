#include<stdio.h>
#include"h1.h"
#include"h2.h"


void p1_print(){
    printf("在p1_print函数中调用：");
    func2();
}

void func1(){
    printf("调用func1函数:\n");
}