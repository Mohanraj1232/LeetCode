import java.util.*;
import java.util.LinkedList;

public class CountingRooms {
  static int R, C;
  static int offsets[][] = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

  static boolean isValid(int currR, int currC) {
    return currR >= 0 && currR < R && currC >= 0 && currC < C;
  }

  static void bfs(int startR, int startC, int[][] matrix) {
    Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[]{startR, startC});
    matrix[startR][startC] = 2;

    while (!queue.isEmpty()) {
        int[] cell = queue.poll();
        int r = cell[0], c = cell[1];

        for (int[] offset : offsets) {
            int newR = r + offset[0];
            int newC = c + offset[1];
            if (isValid(newR, newC) && matrix[newR][newC] == 1) {
                matrix[newR][newC] = 2;
                queue.add(new int[]{newR, newC});
            }
        }
    }
}


  public static void main(String[] args) throws Exception{
    Scanner sc = new Scanner(System.in);
    R = sc.nextInt();
    C = sc.nextInt();
    sc.nextLine();
    int matrix[][] = new int[R][C];
    for (int row = 0; row < R; row++) {
      String str = sc.nextLine().trim();
      for (int col = 0; col < C; col++) {
        matrix[row][col] = str.charAt(col) == '#' ? 2 : 1;
      }
    }

    int count = 0;
    for (int row = 0; row < R; row++) {
      for (int col = 0; col < C; col++) {
        if (matrix[row][col] == 1) {
          bfs(row, col, matrix);
          count++;
        }
      }
    }

    System.out.println(count);
    sc.close();
  }
}
