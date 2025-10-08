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
    return find(segment ,idx * 2 ,nodeLeft ,mid ,queryLeft ,queryRight) ^ find(segment ,idx * 2 + 1 ,mid + 1 ,nodeRight ,queryLeft ,queryRight);
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
        segment[i] = segment[i * 2] ^ segment[i * 2 + 1];
    }

    while(Q -- > 0){
        int left ,right;
        cin >> left >> right;
        cout << find(segment ,1 ,1 ,N ,left ,right) << endl;
    }

}