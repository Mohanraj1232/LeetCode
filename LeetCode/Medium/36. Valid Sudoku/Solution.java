class Solution {
    public boolean isValidSudoku(char[][] board) {
        int R=board.length,C=board[0].length,SS=3;
        int ROW[]=new int[R];
        int COL[]=new int[C];
        int SUB[]=new int[R];

        for(int row=0;row<R;row++){
            for(int col=0;col<C;col++){
                if(board[row][col]!='.'){
                    int subInd=SS*(row/SS)+(col/SS);
                    int dig=board[row][col]-'0';
                    
                    if((ROW[row]&(1<<dig))!=0 || (COL[col]&(1<<dig))!=0 ||(SUB[subInd]&(1<<dig))!=0){
                        return false;
                    }
         
                    ROW[row]|=(1<<dig);
                    COL[col]|=(1<<dig);
                    SUB[subInd]|=(1<<dig);
                }
            }
        }
        return true;
    }
}
