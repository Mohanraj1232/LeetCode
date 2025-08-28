class Solution {
    public int[][] sortMatrix(int[][] grid) {

        int N = grid.length, dLen = N * 2 - 1;

        PriorityQueue<Integer> diagonals[] = new PriorityQueue[dLen];

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                int dInd = (N - 1 - r + c);

                if (diagonals[dInd] == null) {
                    diagonals[dInd] = (dInd <= dLen / 2) ? new PriorityQueue<>(Collections.reverseOrder()): new PriorityQueue<>();
                }

                diagonals[dInd].offer(grid[r][c]);

            }
        }

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                int dInd = (N - 1 - r + c);

                grid[r][c] = diagonals[dInd].poll();

            }
        }

        return grid;
    }
}