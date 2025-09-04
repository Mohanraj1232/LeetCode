package Hard;
import java.util.*;

public class SubarraysGivenSumBoundedMaximum {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt() , K = sc.nextInt() , M = sc.nextInt();
        
        List<Integer> nums = new ArrayList<>();

        for(int i = 0 ; i < N ; i++){
            nums.add(sc.nextInt());
        }

        System.out.println(solve(nums , K , M));
    }
    private static long solve(List<Integer> nums , long k , long m){
        long res = 0;

        int N = nums.size() , prev = 0;

        for(int i = 0 ; i < N ; i++){

            if(nums.get(i) > m){
                res += subarraySum(nums , prev , i , k);
                prev = i + 1;
            }

        }
        res += subarraySum(nums , prev , N , k);

        return res;
    }

    public static long subarraySum(List<Integer> nums,int start, int end ,long k) {
        

        long preSum = 0 , res = 0;

        HashMap<Long,Long> map = new HashMap<>();

        map.put(0L,1L);

        for(int i = start; i < end ; i++){
            preSum += nums.get(i);

            res += map.getOrDefault(preSum - k , 0L);

            map.put(preSum, map.getOrDefault(preSum, 0L) + 1);
        }

        return res;
    }
}
