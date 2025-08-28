class Solution {
    
    private static int[][] diffs = {
        {-2 , -1},
        {-2 , 1},
        {-1 , -2},
        {-1 , 2},
        {2 , -1},
        {2 , 1},
        {1 , -2},
        {1 , 2}
    };
    
    public int minStepToReachTarget(int knightPos[], int targetPos[], int n) {
        
        if(Arrays.equals(knightPos , targetPos)) return 0;
        
        Queue<int[]> que = new LinkedList<>();
        
        int res = 0;
        
        boolean visited[][] = new boolean[n + 1][n + 1];
        
        que.offer(knightPos);
        
        visited[knightPos[0]][knightPos[1]] = true;
        
        while(!que.isEmpty()){
            
            int size = que.size();
            
            while(size-- > 0){
                
                int cur[] = que.poll();
                
                for(int diff[] : diffs){
                    
                    int nR = cur[0] + diff[0] , nC = cur[1] + diff[1];
                    
                    if(!Boundary(n,nR,nC) || visited[nR][nC])
                        continue;
                    
                    if(nR == targetPos[0] && nC == targetPos[1]) return res + 1;
                    
                    visited[nR][nC] = true;
                    
                    que.offer(new int[] {nR , nC});
                    
                }
                
            }
            
            res++;
            
        }
        
        return -1;        
    }
    
    private static boolean Boundary(int n ,int row ,int col){
        return row > 0 && col > 0 && row <= n && col <= n;
    }
}