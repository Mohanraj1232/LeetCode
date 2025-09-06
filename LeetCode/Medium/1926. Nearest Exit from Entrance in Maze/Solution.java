class Solution {

    private int diffs[][] = {
        {0,1},
        {1,0},
        {-1,0},
        {0,-1}
    }; 
    public int nearestExit(char[][] maze, int[] entrance) {

        if(maze[entrance[0]][entrance[1]] == '+') return -1;
        
        int R = maze.length , C = maze[0].length;

        Queue<State> que = new LinkedList<>();

        que.offer(new State(entrance[0] , entrance[1]));

        int res = 0;

        boolean visited[][] = new boolean[R][C];

        visited[entrance[0]][entrance[1]] = true;

        while(!que.isEmpty()){
            int s = que.size();

            while(s-- > 0){
                State cur = que.poll();

                for(int diff[] : diffs){
                    int nR = cur.row + diff[0] , nC = cur.col + diff[1];

                    if(!Boundary(R ,C ,nR ,nC) || visited[nR][nC] || maze[nR][nC] == '+') continue;

                    if(checker(nR , nC , R ,C)) return res + 1;

                    visited[nR][nC] = true;
                    que.offer(new State(nR , nC));
                }
            }

            res++;
        }

        return -1;
    }

    private boolean Boundary(int R ,int C ,int row ,int col){
        return row >= 0 && row < R && col >= 0 && col < C;
    }

    private boolean checker(int row ,int col ,int R ,int C){
        return row == 0 || col == 0 || row == R - 1 || col == C - 1;
    }
}

class State{
    int row;
    int col;

    State(int row , int col){
        this.row = row;
        this.col = col;
    }
}