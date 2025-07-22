class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int R=matrix.length,C=matrix[0].length;
        int DP[][]=new int[R][C];//Creating DP Matrix 
        int res=0;
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                if(DP[i][j]==0){
                    dfs(R,C,i,j,matrix,DP);
                }
                res=Math.max(DP[i][j],res);
            }
        }
        return res;
        
    }
    public void dfs(int R,int C,int row,int col,int[][] matrix,int [][]DP){
        if(DP[row][col]!=0) return;
        int diff[][]={{0,-1},{0,1},{-1,0},{1,0}};
        int max=0;
        for(int ptr=0;ptr<4;ptr++){
            int adjR=row+diff[ptr][0],adjC=col+diff[ptr][1];
            if((adjR>=0 && adjR<R && adjC>=0 && adjC<C) && matrix[row][col]<matrix[adjR][adjC]){
                if(DP[adjR][adjC]==0){
                    dfs(R,C,adjR,adjC,matrix,DP);
                }
                max=Math.max(DP[adjR][adjC],max);
            }
        }
        DP[row][col]=max+1;
    }
}
