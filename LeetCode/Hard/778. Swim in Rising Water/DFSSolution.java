class Solution {
    int min;
    int diffs[][] = {
        {0,1},
        {0,-1},
        {-1,0},
        {1 ,0}
    };
    public int swimInWater(int[][] grid) {
        int R = grid.length ,C = grid[0].length;
        min = Integer.MAX_VALUE;
        dfs(R ,C ,grid ,0 ,0 ,grid[0][0] ,new boolean[R][C]);
        return min;
    }

    private void dfs(int R ,int C ,int grid[][] ,int row ,int col ,int time ,boolean visited[][]){
        if(row == R - 1 && col == C - 1){
            int newtime = (time < grid[row][col]) ? grid[row][col] : time;
            min = Math.min(min ,newtime);
            return;  
        }
        visited[row][col] = true;

        for(int diff[] : diffs){
            int nR = diff[0] + row ,nC = diff[1] + col;
            if(Boundary(nR ,nC ,R ,C) && !visited[nR][nC]){
                int newtime = (time < grid[nR][nC]) ? grid[nR][nC] : time;
                dfs(R ,C ,grid ,nR ,nC ,newtime ,visited);
            }
        }

        visited[row][col] = false;
    }

    private boolean Boundary(int row ,int col ,int R ,int C){
        return row >=0 && row < R && col >= 0 && col < C;
    }
}