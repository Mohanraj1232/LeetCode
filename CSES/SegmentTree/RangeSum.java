import java.io.*;
import java.util.*;

public class RangeSum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        int N = getNextPow2(n);
        long[] segArr = new long[2 * N];

        st = new StringTokenizer(br.readLine());
        for (int i = N; i < N + n; i++) {
            segArr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = N - 1; i >= 1; i--) {
            segArr[i] = segArr[2 * i] + segArr[2 * i + 1];
        }

        StringBuilder sb = new StringBuilder();
        for (int q = 0; q < Q; q++) {
            st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            sb.append(find(segArr, 1, 1, N, left, right)).append('\n');
        }

        System.out.print(sb.toString());
    }

    private static long find(long[] segArr, int idx, int nodeLeft, int nodeRight, int queryLeft, int queryRight) {
        if (nodeRight < queryLeft || nodeLeft > queryRight) {
            return 0L;
        }
        if (queryLeft <= nodeLeft && queryRight >= nodeRight) {
            return segArr[idx];
        }
        int mid = (nodeLeft + nodeRight) / 2;
        return find(segArr, idx * 2, nodeLeft, mid, queryLeft, queryRight) +
               find(segArr, idx * 2 + 1, mid + 1, nodeRight, queryLeft, queryRight);
    }

    private static int getNextPow2(int n) {
        int pow = 0;
        while ((1 << pow) < n) pow++;
        return 1 << pow;
    }
}
