import java.io.*;
import java.util.*;
 
class Main {
  public static void main(String[] args) {
    FastScanner sc = new FastScanner();
    int N = sc.nextInt();
    int Q = sc.nextInt();
    int[] nums = new int[N];
    for (int i = 0; i < N; i++)
      nums[i] = sc.nextInt();
 
    // K = floor(log2(N)) + 1
    int K = 32 - Integer.numberOfLeadingZeros(N);
    int[][] matrix = new int[K][N];
 
    for (int i = 0; i < N; i++)
      matrix[0][i] = nums[i];
 
    for (int k = 1; k < K; k++) {
      int len = 1 << k;
      int half = 1 << (k - 1);
      for (int i = 0; i + len <= N; i++) {
        matrix[k][i] = Math.min(matrix[k - 1][i], matrix[k - 1][i + half]);
      }
    }
 
    StringBuilder sb = new StringBuilder(Math.min(Q, 1_000_000));
    for (int q = 0; q < Q; q++) {
      int start = sc.nextInt() - 1;
      int end = sc.nextInt() - 1;
      int len = end - start + 1;
      int level = 31 - Integer.numberOfLeadingZeros(len);
      int left = matrix[level][start];
      int right = matrix[level][end - (1 << level) + 1];
      sb.append(Math.min(left, right)).append('\n');
    }
    System.out.print(sb.toString());
    sc.close();
  }
 
  // Faster scanner using a byte buffer (commonly used in competitive programming)
  static class FastScanner {
    private final InputStream in = System.in;
    private final byte[] buffer = new byte[1 << 16];
    private int ptr = 0, len = 0;
 
    private int read() throws RuntimeException {
      if (ptr >= len) {
        try {
          len = in.read(buffer);
        } catch (IOException e) {
          throw new RuntimeException(e);
        }
        ptr = 0;
        if (len <= 0)
          return -1;
      }
      return buffer[ptr++];
    }
 
    int nextInt() {
      int c = read();
      while (c <= ' ') {
        if (c == -1)
          throw new NoSuchElementException();
        c = read();
      }
      int sign = 1;
      if (c == '-') {
        sign = -1;
        c = read();
      }
      int val = 0;
      while (c > ' ') {
        val = val * 10 + (c - '0');
        c = read();
      }
      return val * sign;
    }
 
    void close() {
      try {
        in.close();
      } catch (IOException e) {
        // ignore
      }
    }
  }
}