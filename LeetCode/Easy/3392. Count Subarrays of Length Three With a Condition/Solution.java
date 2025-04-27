class Solution {
    public int countSubarrays(int[] nums) {
        int res=0;

        for(int i=0;i<nums.length-2;i++){
            if(nums[i]+nums[i+2]==nums[i+1]/2.0){
                res++;
            }
        }

        return res;
    }
}
