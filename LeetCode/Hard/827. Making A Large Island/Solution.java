class Solution {

    int dirs[][]={{0,1},{1,0},{-1,0},{0,-1}};

    public int largestIsland(int[][] grid) {

        int R=grid.length,C=grid[0].length,island_counter=2;

        int res=0;

        Set<int[]> zero=new HashSet<>();

        for(int row=0;row<R;row++){
            for(int col=0;col<C;col++){
                if(grid[row][col]==1){
                    grid[row][col]=island_counter;
                    dfs(R,C,grid,island_counter,row,col);
                    island_counter++;
                }else if(grid[row][col]==0){
                    zero.add(new int[] {row,col});
                }
            }
        }

        int island_area[]=new int[island_counter-1];

        for(int row=0;row<R;row++){
            for(int col=0;col<C;col++){
                if(grid[row][col]!=0) island_area[grid[row][col]-1]++;
            }
        }

        for(int i=1;i<island_counter-1;i++){
            res=Math.max(res,island_area[i]);
        }

        for(int cell[]:zero){
            boolean visited[]=new boolean[island_counter-1];
            int area=1;
            for(int dir[]:dirs){
                int r=cell[0]+dir[0],c=cell[1]+dir[1];
                if(r>=0 && r<R && c>=0 && c<C && grid[r][c]!=0 && !visited[grid[r][c]-1]){
                    visited[grid[r][c]-1]=true;
                    area+=island_area[grid[r][c]-1];                    
                }
            }
            res=Math.max(res,area);
        }

        return res;

    }


    public void dfs(int R,int C,int[][] grid,int island_counter,int row,int col){
        for(int dir[]:dirs){
            int newR=row+dir[0],newC=col+dir[1];

            if(newR>=0 && newR<R && newC>=0 && newC<C && grid[newR][newC]==1 && grid[newR][newC]!=island_counter){
                grid[newR][newC]=island_counter;
                dfs(R,C,grid,island_counter,newR,newC);
            }
        }
    }
}