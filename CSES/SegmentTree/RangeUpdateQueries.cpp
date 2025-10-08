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

ll find(ll segment[] ,int idx ,int nodeLeft ,int nodeRight ,int queryLeft ,int queryRight){
    if(nodeRight < queryLeft || nodeLeft > queryRight){
        return 0;
    }
    if(queryLeft <= nodeLeft && nodeRight <= queryRight){
        return segment[idx];
    }
    int mid = (nodeLeft + nodeRight) / 2;
    ll left = find(segment ,idx * 2 ,nodeLeft ,mid ,queryLeft ,queryRight);
    ll right = find(segment ,idx * 2 + 1 ,mid + 1 ,nodeRight ,queryLeft ,queryRight);
    return segment[idx] + left + right;
}

void update(ll segment[] ,int idx ,int nodeLeft ,int nodeRight  ,int queryLeft ,int queryRight ,ll u){
    if(nodeRight < queryLeft || nodeLeft > queryRight){
        return;
    }
    if(queryLeft <= nodeLeft && nodeRight <= queryRight){
        segment[idx] += u;
        return;
    }
    int mid = (nodeLeft + nodeRight) /2;

    update(segment ,idx * 2 ,nodeLeft ,mid ,queryLeft ,queryRight ,u);
    update(segment ,idx * 2 + 1 ,mid + 1 ,nodeRight ,queryLeft ,queryRight ,u);
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

    while(Q -- > 0){
        int type;
        cin >> type;
        if(type == 1){
            int left ,right;
            ll u;
            cin >> left >> right >> u;
            update(segment ,1 ,1 ,N ,left ,right ,u);
        }else{
            int k;
            cin >> k;
            cout << find(segment ,1 ,1 ,N ,k ,k) << endl;
        }
    }

}