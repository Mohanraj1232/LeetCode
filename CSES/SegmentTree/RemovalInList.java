import java.io.*;
import java.util.*;

public class RemovalInList {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        while (N-- > 0) {
            int pos = Integer.parseInt(st.nextToken()) - 1; // 1-based to 0-based index
            System.out.print(list.get(pos) + " ");
            list.remove(pos);
        }
    }
}
