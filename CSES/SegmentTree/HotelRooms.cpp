#include <iostream>
using namespace std;
#define ll long long int

ll getNext2Pow(ll N){
    ll pow = 0;
    while((1 << pow) < N){
        pow++;
    }
    return 1 << pow;
}

ll find(ll segment[] ,int idx ,int nodeLeft ,int nodeRight ,int room){
    if(nodeRight == nodeLeft){
        if(segment[idx] < room){
            return 0;
        }
        segment[idx] -= room;
        return idx;
    }
    ll res = 0;
    if(room <= segment[idx * 2]){
        res = find(segment ,idx * 2 ,nodeLeft ,(nodeLeft + nodeRight) / 2 ,room); 
    }else if(room <= segment[idx * 2 + 1]){
        res = find(segment ,idx * 2 + 1,(nodeLeft + nodeRight) / 2 + 1 ,nodeRight ,room);
    }

    segment[idx] = max(segment[idx * 2] ,segment[idx * 2 + 1]);
    return res;
}

int main(){
    ll n ,Q;
    cin >> n >> Q;
    ll N = getNext2Pow(n);

    ll segment[N * 2];
    fill(segment ,segment + N * 2 ,0);

    for(int i = N; i < N + n; i++){
        cin >> segment[i];
    }

    for(int i = N - 1; i >= 1; i--){
        segment[i] = max(segment[i * 2] , segment[i * 2 + 1]);
    }

    cout << endl;

    while(Q -- > 0){
        int room;
        cin >> room;
        ll res = find(segment ,1 ,1 ,N ,room); 
        if(res == 0){
            cout << 0 << endl;
        }else{
            cout << res - N  + 1<< endl;
        }
    }

}