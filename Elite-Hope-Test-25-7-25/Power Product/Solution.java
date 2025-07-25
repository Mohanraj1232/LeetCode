import java.util.*;

public class Solution {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        long Num = sc.nextLong();
        int n=sc.nextInt();
        
        PriorityQueue<Long> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0;i<n;i++){
            pq.add(sc.nextLong());
        }

        for(int i=0;i<n;i++){
            long val=pq.poll();

            if(val==1) continue;

            while(Num % val == 0) {
                Num /= val;
            }
        }

        System.out.println(Num == 1 ? "Yes" : "No");

    }
}
