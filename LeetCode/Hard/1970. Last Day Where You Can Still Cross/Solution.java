class Solution {
    
    private int diffs[][]={{0,1},{1,0},{0,-1},{-1,0}
                            ,{1,1},{-1,-1},{1,-1},{-1,1}};
    

    private boolean isInBounds(int R,int C,int row,int col){
        return row>=1 && row<=R && col>=1 && col<=C;
    }

    private int matIndexToarrIndex(int R,int C,int row,int col){
        return ((row * C) + col) - C;
    }

    public int latestDayToCross(int R, int C, int[][] cells) {

        int leader[]=new int[R*C + 2];

        for(int i=0;i<R*C+2;leader[i]=i++);

        int days=0;
        int lGoal=0;
        int rGoal=R*C + 1;

        boolean isWatered[]=new boolean[R*C + 1];

        for(int cell[]:cells){
            int row=cell[0];
            int col=cell[1];
    
            int ind=matIndexToarrIndex(R,C,row,col);
            isWatered[ind]=true;

            for(int diff[]:diffs){
                int newR=row+diff[0];
                int newC=col+diff[1];

                if(!isInBounds(R,C,newR,newC))
                    continue;
                
                int newind=matIndexToarrIndex(R,C,newR,newC);

                if(isWatered[newind])
                    join(leader,newind,ind);
            }

            if(col==1){
                join(leader,ind,lGoal);
            }else if(col==C){
                join(leader,ind,rGoal);
            }

            if(find(leader,lGoal)==find(leader,rGoal)){
                return days;
            }
            days++;
        }

        return -1;
    }

    private void join(int []leader,int left,int right){
        
        int lLeader=find(leader,left);
        int rLeader=find(leader,right);
        
        if(lLeader!=rLeader){
            leader[rLeader]=lLeader;
        }

    }


    private int find(int []leader,int node){

        if(leader[node]==node) return node;

        leader[node]=find(leader,leader[node]);

        return leader[node];

    }
}