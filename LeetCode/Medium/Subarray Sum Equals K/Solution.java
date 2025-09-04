class Solution {
    public int subarraySum(int[] nums, int k) {
        
        int N = nums.length;

        int preSum = 0 , res = 0;

        HashMap<Integer,Integer> map = new HashMap<>();

        map.put(0,1);

        for(int i = 0; i < N ; i++){
            preSum += nums[i];

            res += map.getOrDefault(preSum - k , 0);

            map.put(preSum, map.getOrDefault(preSum, 0) + 1);
        }

        return res;
    }
}