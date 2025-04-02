class Cell{
    int row,col;
    Cell(int row,int col){
        this.row=row;
        this.col=col;
    }
}
class Solution {
    int get_sub_ind(int row,int col,int Subsize){
        return Subsize*(row/Subsize)+(col/Subsize);
    }
    Cell getUnfilledCell(char[][] board,int R,int C){
        for(int row=0;row<R;row++){
            for(int col=0;col<C;col++){
                if(board[row][col]=='.'){
                    return new Cell(row,col);
                }
            }
        }
        return null;
    }
    public void solveSudoku(char[][] board) {
        int R=board.length,C=board[0].length;
        int Size=board.length,SubSize=(int)Math.sqrt(Size);
        int SUBF[]=new int[Size];
        int ROWF[]=new int[Size];
        int COLF[]=new int[Size];
        for(int row=0;row<R;row++){
            for(int col=0;col<C;col++){
                if(board[row][col]!='.'){
                    int digit=1<<((board[row][col]-'0'));
                    ROWF[row]|=digit;
                    COLF[col]|=digit;
                    SUBF[get_sub_ind(row,col,SubSize)]|=digit;
                }
            }
        }
        solve(R,C,3,board,ROWF,COLF,SUBF);
        
    }
    boolean solve(int R,int C,int SMS,char[][] board,int rowf[],int colf[],int subf[]){
        Cell toFill=getUnfilledCell(board,R,C);
        if(toFill==null){
            return true;
        }
        for(int dig=1;dig<=9;dig++){
            if((rowf[toFill.row]&(1<<dig))==0 && (colf[toFill.col]&(1<<dig))==0 && (subf[get_sub_ind(toFill.row,toFill.col,SMS)]&(1<<dig))==0){
                board[toFill.row][toFill.col]=(char)('0'+dig);
                rowf[toFill.row]|=(1<<dig);
                colf[toFill.col]|=(1<<dig);
                subf[get_sub_ind(toFill.row,toFill.col,SMS)]|=(1<<dig);
                boolean solved=solve(R,C,SMS,board,rowf,colf,subf);
                if(solved){
                    return true;
                }
                board[toFill.row][toFill.col]='.';
                rowf[toFill.row]^=(1<<dig);
                colf[toFill.col]^=(1<<dig);
                subf[get_sub_ind(toFill.row,toFill.col,SMS)]^=(1<<dig);
            }
        }
        return false;
    }
}