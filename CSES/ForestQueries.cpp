#include <iostream>
using namespace std;

int main() {
	
	int N ,Q;
	cin >> N >> Q;
	int mat[N + 1][N + 1];

    for(int r = 0; r <= N; r++){
        mat[r][0] = 0;
    }
    for(int c = 0; c <= N; c++){
        mat[0][c] = 0;
    }

	for(int r = 1; r <= N; r++){
	    for(int c = 1; c <= N; c++){
	        char ch;
	        cin >> ch;
	        mat[r][c] = ((ch == '*') ? 1 : 0) + mat[r][c - 1];
	    }
	}

	for(int c = 1; c <= N; c++){
	    for(int r = 1; r <= N; r++){
	        mat[r][c] += mat[r - 1][c];
	    }
	}
    
    while(Q--){
        int r1 ,r2 ,c1 ,c2;
        cin >> r1 >> c1 >> r2 >> c2;
        
        cout << mat[r2][c2] - mat[r2][c1 - 1] - mat[r1 - 1][c2] + mat[r1 - 1][c1 - 1] << endl;
    }

}
