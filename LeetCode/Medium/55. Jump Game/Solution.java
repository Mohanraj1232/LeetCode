class Solution {
    public boolean canJump(int[] nums) {
       int N=nums.length,maxReach=0;
       for(int ptr=0;ptr<N-1;ptr++){
        if(maxReach>=ptr){
            maxReach=Math.max(maxReach,(ptr+nums[ptr]));
            if(maxReach>=N-1) return true;
        }else{
            return false;
        }
       } 
       return maxReach>=N-1;
    }
}
