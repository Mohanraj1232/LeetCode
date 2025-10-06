import java.io.*;
import java.util.*;

public class StaticRangeSumQueries {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        long[] preSum = new long[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            preSum[i] = preSum[i - 1] + Long.parseLong(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();


        for (int q = 0; q < Q; q++) {
            st = new StringTokenizer(br.readLine());
            int stIdx = Integer.parseInt(st.nextToken());
            int endIdx = Integer.parseInt(st.nextToken());
            sb.append(preSum[endIdx] - preSum[stIdx - 1]).append("\n");
        }

        System.out.print(sb.toString());
    }
}
