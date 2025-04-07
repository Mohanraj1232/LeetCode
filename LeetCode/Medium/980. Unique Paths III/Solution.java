class Solution {
    int res;
    int diff[][]={{0,1},{1,0},{0,-1},{-1,0}};
    public int uniquePathsIII(int[][] grid) {
        int R=grid.length,C=grid[0].length,row=0,col=0;
        int visited[]=new int[R];
        res=0;

        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                if(grid[i][j]==1){
                    row=i;
                    col=j;
                    visited[i]|=(1<<j);
                }else if(grid[i][j]==-1){
                    visited[i]|=(1<<j);
                }
            }
        }
        DFS(R,C,grid,row,col,visited);
        return res;

    }

    public boolean DFS(int R,int C,int [][]grid,int row,int col,int[] visited){
        if(grid[row][col]==2){
            if(isAllused(R,C,visited)){
                res++;
                return true;
            }
        }
        for(int i=0;i<4;i++){
            int adjR=row+diff[i][0],adjC=col+diff[i][1];

            if(helper(R,C,adjR,adjC) && (visited[adjR]&(1<<adjC))==0 && grid[adjR][adjC]!=-1){
                visited[adjR]|=(1<<adjC); 

                DFS(R,C,grid,adjR,adjC,visited);

                visited[adjR]^=(1<<adjC); //Backtracking

            }
        }
        return false;

    }

    boolean isAllused(int R,int C,int[] visited){
        for(int i=0;i<R;i++){
            if((visited[i]&((1<<C)-1))!=((1<<C)-1)) return false;
        }
        return true;
    }

    boolean helper(int R,int C,int row,int col){
        return (row>=0 && row<R && col>=0 && col<C);
    }
}
