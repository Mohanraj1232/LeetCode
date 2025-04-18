class Solution {
    int res;
    public int totalNQueens(int n) {
        res=0;
    
        boolean COL[]=new boolean[n];
        boolean LRDiagonal[]=new boolean[n*2 - 1];
        boolean RLDiagonal[]=new boolean[n*2 - 1];
        solve(n,0,COL,LRDiagonal,RLDiagonal);

        return res;
    }
    public void solve(int n,int row,boolean COL[],boolean LRDiagonal[],boolean RLDiagonal[]){
        if(row==n){
            res++;
            return;
        }

        for(int col=0;col<n;col++){
            if(!COL[col] && !RLDiagonal[row+col] && !LRDiagonal[n+(row-col)-1]){

                COL[col]=true;
                RLDiagonal[row+col]=true;
                LRDiagonal[n+(row-col)-1]=true;

                solve(n,row+1,COL,LRDiagonal,RLDiagonal);

                COL[col]=false;
                RLDiagonal[row+col]=false;
                LRDiagonal[n+(row-col)-1]=false;
            }
        }
    }
}
