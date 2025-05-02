class Solution {
    public void sortColors(int[] nums) {
        int arr[]=new int[3];
        for(int i:nums){
            arr[i]++;
        }
        int k=0;
        for(int i=0;i<3;i++){
            for(int j=0;j<arr[i];j++){
                nums[k++]=i;
            }
        }
    }
}
