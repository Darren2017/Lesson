#include<iostream>

using namespace std;

int main()
{
    char a[100];
    cin >> a;
    int i = 1,  j = 1, len = strlen(a);
    if(!((a[0] >= 'a' && a[0] <= 'z') || (a[0] >= 'A' && a[0] <= 'Z'))){
        j--;
    }
    for(; i < len; i++){
        if((a[i] >= 'a' && a[i] <= 'z') || (a[i] >= 'A' && a[i] <= 'Z') || (a[i] >= '1' && a[i] <= '9')){
            a[j++] = a[i];
        }
    }
    a[j] = '\0';
    cout << a << endl;
}