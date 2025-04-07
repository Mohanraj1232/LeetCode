class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int R = obstacleGrid.length, C = obstacleGrid[0].length;
        
        if (obstacleGrid[0][0] == 1 || obstacleGrid[R - 1][C - 1] == 1) {
            return 0;
        }

        int[][] DP = new int[R][C];

        DP[0][0] = 1;

        for (int row = 1; row < R; row++) {
            DP[row][0] = (obstacleGrid[row][0] == 1) ? 0 : DP[row - 1][0];
        }

        for (int col = 1; col < C; col++) {
            DP[0][col] = (obstacleGrid[0][col] == 1) ? 0 : DP[0][col - 1];
        }

        for (int row = 1; row < R; row++) {
            for (int col = 1; col < C; col++) {
                if (obstacleGrid[row][col] != 1) {
                    DP[row][col] = DP[row - 1][col] + DP[row][col - 1];
                }
            }
        }

        return DP[R - 1][C - 1];
    }
}
