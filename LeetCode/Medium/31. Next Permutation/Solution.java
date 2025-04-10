class Solution {
    public void nextPermutation(int[] nums) {
        int ind=-1;
        int n=nums.length;
        for(int i=n-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                ind=i;
                break;
            }
        }
        if(ind==-1){
            int s=0,e=n-1;
            while(s<e){
                int temp=nums[s];
                nums[s]=nums[e];
                nums[e]=temp;
                s++;e--;
            }
            return;
        }
        for(int i=n-1;i>ind;i--){
            if(nums[i]>nums[ind]){
                int temp=nums[i];
                nums[i]=nums[ind];
                nums[ind]=temp;
                int s=ind+1,e=n-1;
                while(s<e){
                    temp=nums[s];
                    nums[s]=nums[e];
                    nums[e]=temp;
                    s++;e--;
                }
                return;
            }
        }
        
    }
}
