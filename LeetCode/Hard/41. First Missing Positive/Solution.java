class Solution {
    public int firstMissingPositive(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int N=nums.length;

        for(int i=0;i<N;i++){
            map.put(nums[i],i);
        }

        for(int i=1;i<=N;i++){
            if(map.get(i)==null) return i;
        }
        return N+1;
    }
}
