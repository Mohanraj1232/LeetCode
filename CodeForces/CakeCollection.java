import java.util.*;

public class CakeCollection {
    static class Oven {
        long rate;       // cakes per second
        long lastVisit;  // last second we collected
        long stored;     // leftover (always 0 after collect)

        Oven(long rate) {
            this.rate = rate;
            this.lastVisit = 0;
            this.stored = 0;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            long m = sc.nextLong();
            long[] a = new long[n];
            for (int i = 0; i < n; i++) a[i] = sc.nextLong();

            // global current time (seconds)
            final long[] curTime = {0};

            // custom comparator: max heap based on effective cakes
            PriorityQueue<Oven> pq = new PriorityQueue<>((o1, o2) -> {
                long val1 = o1.stored + (curTime[0] - o1.lastVisit) * o1.rate;
                long val2 = o2.stored + (curTime[0] - o2.lastVisit) * o2.rate;
                return Long.compare(val2, val1);
            });

            for (int i = 0; i < n; i++) {
                pq.offer(new Oven(a[i]));
            }

            long total = 0;

            for (int sec = 1; sec <= m; sec++) {
                curTime[0] = sec;

                Oven best = pq.poll();
                long cakes = best.stored + (sec - best.lastVisit) * best.rate;
                total += cakes;

                best.stored = 0;
                best.lastVisit = sec;
                pq.offer(best);
            }

            System.out.println(total);
        }
    }
}
