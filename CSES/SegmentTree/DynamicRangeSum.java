import java.io.*;
import java.util.*;

public class DynamicRangeSum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        int N = getNextPow2(n);
        long[] segArr = new long[2 * N];
        Arrays.fill(segArr, 0);

        st = new StringTokenizer(br.readLine());
        for (int i = N; i < N + n; i++) {
            segArr[i] = Long.parseLong(st.nextToken());
        }

        // Build the segment tree
        for (int i = N - 1; i >= 1; i--) {
            segArr[i] = segArr[2 * i] + segArr[2 * i + 1];
        }

        StringBuilder sb = new StringBuilder();
        for (int q = 0; q < Q; q++) {
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            if (type == 1) {
                int k = Integer.parseInt(st.nextToken());
                long u = Long.parseLong(st.nextToken());
                update(segArr, 1, 1, N, k, u);
            } else {
                int left = Integer.parseInt(st.nextToken());
                int right = Integer.parseInt(st.nextToken());
                sb.append(find(segArr, 1, 1, N, left, right)).append('\n');
            }
        }

        System.out.print(sb.toString());
    }

    // Range Sum Query
    private static long find(long[] segArr, int idx, int nodeLeft, int nodeRight, int queryLeft, int queryRight) {
        if (nodeRight < queryLeft || nodeLeft > queryRight)
            return 0;

        if (queryLeft <= nodeLeft && nodeRight <= queryRight)
            return segArr[idx];

        int mid = (nodeLeft + nodeRight) / 2;
        return find(segArr, idx * 2, nodeLeft, mid, queryLeft, queryRight)
                + find(segArr, idx * 2 + 1, mid + 1, nodeRight, queryLeft, queryRight);
    }

    private static void update(long[] segArr, int idx, int nodeLeft, int nodeRight, int k, long u) {
        if (nodeLeft == nodeRight) {
            segArr[idx] = u;
            return;
        }
     
        int mid = (nodeLeft + nodeRight) / 2;
        if (k <= mid)
            update(segArr, idx * 2, nodeLeft, mid, k, u);
        else
            update(segArr, idx * 2 + 1, mid + 1, nodeRight, k, u);

        segArr[idx] = segArr[idx * 2] + segArr[idx * 2 + 1];
    }

    private static int getNextPow2(int n) {
        int pow = 0;
        while ((1 << pow) < n)
            pow++;
        return 1 << pow;
    }
}
