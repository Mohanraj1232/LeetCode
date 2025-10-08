#include <bits/stdc++.h>
using namespace std;
#define ll long long int

int main() {

    int N, Q;

    cin >> N >> Q;

    int mat[N][N];
    char ch;
    for(int i=0; i<N; i++){
        for(int j=0; j<N; j++){
            cin>>ch;
            if(ch == '*'){
                mat[i][j] = 1;
            }else{
                mat[i][j] = 0;
            }
        }
    }

    for(int i = 0; i < N; i++){
        
    }
}