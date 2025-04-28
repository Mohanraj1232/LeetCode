class Solution {
    int diff[][]={{1,0},{-1,0},{0,1},{0,-1}};
    public boolean exist(char[][] board, String word) {
        int R=board.length,C=board[0].length;
        int len=word.length();
        boolean visited[][]=new boolean[R][C];
        for(int row=0;row<R;row++){
            for(int col=0;col<C;col++){
                if(board[row][col]==word.charAt(0)){
                    if(dfs(R,C,board,word,1,row,col,len,visited)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public boolean dfs(int R,int C,char[][] board,String word,int wi,int row,int col,int len,boolean[][] visited){
        if(wi==len) return true;
        visited[row][col]=true;
        boolean result=false;
        for(int i=0;i<4;i++){
            int adjR=row+diff[i][0];
            int adjC=col+diff[i][1];
            if((0<=adjR && adjR<R && 0<=adjC && adjC<C) && board[adjR][adjC]==word.charAt(wi) && !visited[adjR][adjC]){
                result=result | dfs(R,C,board,word,wi+1,adjR,adjC,len,visited);
            }
        }
        visited[row][col]=false;
        return result;
    }
}
