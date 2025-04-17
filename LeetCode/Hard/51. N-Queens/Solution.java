class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res=new ArrayList<>();
        
        boolean COL[]=new boolean[n];
        boolean LRDiagonal[]=new boolean[n*2 - 1];
        boolean RLDiagonal[]=new boolean[n*2 - 1];
        List<String> cur=new ArrayList<>();
        solve(n,0,cur,res,COL,LRDiagonal,RLDiagonal);

        return res;
    }
    public void solve(int n,int row,List<String> cur,List<List<String>> res,boolean COL[],boolean LRDiagonal[],boolean RLDiagonal[]){
        if(row==n){
            res.add(new ArrayList<> (cur));
            return;
        }

        for(int col=0;col<n;col++){
            if(!COL[col] && !RLDiagonal[row+col] && !LRDiagonal[n+(row-col)-1]){
                char[] temp=new char[n];
                Arrays.fill(temp,'.');
                temp[col]='Q';
                cur.add(new String(temp));

                COL[col]=true;
                RLDiagonal[row+col]=true;
                LRDiagonal[n+(row-col)-1]=true;

                solve(n,row+1,cur,res,COL,LRDiagonal,RLDiagonal);

                COL[col]=false;
                RLDiagonal[row+col]=false;
                LRDiagonal[n+(row-col)-1]=false;
                
                cur.remove(cur.size()-1);
            }
        }
    }
}
