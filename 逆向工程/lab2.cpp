#include<iostream>
#include<stdio.h>
#include<Windows.h>

using namespace std;

int main()
{
    string name, serial, ch_name;
    cout << "Please input name: ";
    cin >> name;
    ch_name = name;
    for(int i = 0; i < name.size(); i++){
        int c = (i ^ name[i] % 10) + 2;
        if((char)c >= 10){
            ch_name[i] = LOBYTE(c) -10;
        }
        ch_name[i] = c;
    }
    char key[20];
    for(int i = 0; i < ch_name.size(); i++){
        key[i] = (char)(ch_name[i] + 70);
    }
    printf("\nseial is %s", key);

    return 0;
}