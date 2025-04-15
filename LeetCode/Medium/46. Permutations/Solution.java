class Solution {
    public List<List<Integer>> permute(int[] nums) {
        int len=nums.length;
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> cur =new ArrayList<>();
        boolean isused[]=new boolean[len];

        solve(len,nums,cur,res,0,isused);
        return res;

    }

    public void solve(int len,int[] nums,List<Integer> cur,List<List<Integer>> res,int curLen,boolean isused[]){
        if(curLen==len){
            res.add(new ArrayList<>(cur));
            return;
        }
        for(int i=0;i<len;i++){
            if(!isused[i]){
                isused[i]=true;
                cur.add(nums[i]);
                solve(len,nums,cur,res,curLen+1,isused);
                isused[i]=false;
                cur.remove(cur.size()-1);
            }
        }

    }
}
