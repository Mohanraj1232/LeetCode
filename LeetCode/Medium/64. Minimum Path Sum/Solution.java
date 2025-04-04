class Solution {
    public int minPathSum(int[][] mat) {
        int R=mat.length,C=mat[0].length;
        
        for(int row=1;row<R;row++) mat[row][0]+=mat[row-1][0];
        for(int col=1;col<C;col++) mat[0][col]+=mat[0][col-1];
        for(int row=1;row<R;row++){
            for(int col=1;col<C;col++){
                mat[row][col]+=(Math.min(mat[row-1][col],mat[row][col-1]));
            }
        }
        
        return mat[R-1][C-1];
    }
}