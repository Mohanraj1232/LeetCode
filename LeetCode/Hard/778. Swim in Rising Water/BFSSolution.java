class Solution {
    int diffs[][] = {
        {0,1},
        {0,-1},
        {-1,0},
        {1 ,0}
    };
    public int swimInWater(int[][] grid) {
        int R = grid.length ,C = grid[0].length;
        return bfs(R ,C ,grid ,new boolean[R][C]);
    }

    private int bfs(int R ,int C ,int [][]grid ,boolean [][]visited){
        PriorityQueue<State> que = new PriorityQueue<>((a, b) -> a.time - b.time);

        que.offer(new State(0 ,0 ,grid[0][0]));
        visited[0][0] = true;

        while(!que.isEmpty()){
            int s = que.size();

            while(s-- > 0){
                State cur = que.poll();
                for(int diff[] : diffs){
                    int nR = diff[0] + cur.row ,nC = diff[1] + cur.col;
                    if(Boundary(nR ,nC ,R ,C) && !visited[nR][nC]){
                        visited[nR][nC] = true;
                        int newtime = (cur.time < grid[nR][nC]) ? grid[nR][nC] : cur.time;
                        if(nR == R - 1 && nC == C - 1){
                            return newtime;
                        }
                        que.offer(new State(nR ,nC ,newtime));
                    }
                }
            }
        }
        return 0;
    }

    private boolean Boundary(int row ,int col ,int R ,int C){
        return row >=0 && row < R && col >= 0 && col < C;
    }
}

class State{
    int row;
    int col;
    int time;
    State(int row ,int col ,int time){
        this.row = row;
        this.col = col;
        this.time = time;
    }
}