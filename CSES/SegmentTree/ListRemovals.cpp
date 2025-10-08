#include <iostream>
using namespace std;

int getNext2Pow(int n){
    int pow = 0;
    
    while((1 << pow) < n){
        pow++;
    }
    
    return 1 << pow;
}

int find(int segment[] ,int idx ,int nodeLeft ,int nodeRight ,int pos){
    if(nodeRight == nodeLeft){
        segment[idx] = 0;
        return idx;
    }
    int res = -1 ,mid = (nodeLeft + nodeRight) / 2;
    if(segment[idx * 2] >= pos){
        res = find(segment ,idx * 2 ,nodeLeft ,mid ,pos);
    }else{
        res = find(segment ,idx * 2 + 1 ,mid + 1 ,nodeRight ,pos - segment[idx * 2]);
    }
    segment[idx] = segment[idx * 2] + segment[idx * 2 + 1];
    return res;
}

int main() {
	
	int n;
	
	cin >> n;
	
	int N = getNext2Pow(n);

    int segment[N * 2];
    int arr[n];
    
    for(int i = 0; i < n; i++){
        cin >> arr[i];
        segment[N + i] = 1;
    }
    
    for(int i = N - 1; i >= 1; i--){
        segment[i] = segment[i * 2] + segment[i * 2 + 1];
    }
    
    while(n--){
        int pos;
        cin >> pos;
        int idx = find(segment ,1 ,1 ,N ,pos);
        
        cout << arr[idx - N] << " ";
    }
}
