class Solution {
    public int countSquares(int[][] matrix) {
        int R = matrix.length, C = matrix[0].length;
        
        int DP[][] = new int[R][C];
        int sum = 0;

        for(int row = 0 ; row < R ; row++){
            DP[row][0] = matrix[row][0];
            sum += DP[row][0];
        }
        
        for(int col = 1 ; col < C ; col++){
            DP[0][col] = matrix[0][col];
            sum += DP[0][col];
        }

        for(int r = 1 ; r < R ; r++){
            for(int c = 1 ; c < C ; c++){
                if(matrix[r][c] == 0) 
                    continue;

                DP[r][c] = Math.min(DP[r - 1][c - 1] ,Math.min(DP[r - 1][c] ,DP[r][c - 1])) + 1;

                sum += DP[r][c];
            }
        }

        return sum;
    }
}