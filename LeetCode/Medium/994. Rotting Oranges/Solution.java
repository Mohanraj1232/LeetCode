class Solution {
    int[][] diff={{1,0},{-1,0},{0,1},{0,-1}};
    public boolean boundarychecker(int R,int C,int r,int c){
        return (r>=0 && r<R && c>=0 && c<C);
    }
    public int orangesRotting(int[][] grid) {
        int R=grid.length,C=grid[0].length,fresh=0;
        Queue<List<Integer>> queue=new LinkedList<>();


        for(int row=0;row<R;row++){
            for(int col=0;col<C;col++){
                if(grid[row][col]==2){
                    queue.add(Arrays.asList(row, col));
                }else if(grid[row][col]==1) fresh++;
            }
        }
        if(fresh==0) return 0;
        int res=-1;
        while(!queue.isEmpty()){
            int size=queue.size();
            for(int i=0;i<size;i++){
                int r=queue.peek().get(0),c=queue.peek().get(1);
                queue.poll();
                for(int ptr=0;ptr<4;ptr++){
                    int adjR=diff[ptr][0]+r,adjC=diff[ptr][1]+c;
                    if(boundarychecker(R,C,adjR,adjC) && grid[adjR][adjC]==1){
                        grid[adjR][adjC]=2;
                        queue.add(Arrays.asList(adjR, adjC));
                        fresh--;
                    }
                }
            }
            res++;
        }
        return (fresh==0)?res:-1;
    }
}