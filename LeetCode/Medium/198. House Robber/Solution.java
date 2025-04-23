class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1){
            return nums[0];
        }else if(n==2){
            return (nums[0]>nums[1])?nums[0]:nums[1];
        }


        int[] DP=new int[n];
        int[] MAX_DP=new int[n];

        DP[0]=nums[0];
        DP[1]=nums[1];
        MAX_DP[0]=nums[0];
        MAX_DP[1]=Math.max(nums[0],nums[1]);

        for(int i=2;i<n;i++){
            DP[i]=MAX_DP[i-2]+nums[i];
            MAX_DP[i]=Math.max(MAX_DP[i-1],DP[i]);
        }

        return MAX_DP[n-1];



    }
}
