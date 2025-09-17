class Solution {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        
        List<Integer> res = new ArrayList<>();

        res.add(nums[0]);

        for(int i = 1 ; i < nums.length ; i++){
            res.add(nums[i]);

            while(res.size() > 1){
                int val1 = res.get(res.size() - 1) , val2 = res.get(res.size() - 2);

                int GCD = gcd(val1 , val2);

                if(GCD == 1){
                    break;
                }
                
                res.remove(res.size() - 1);
                res.remove(res.size() - 1);
                res.add((val1 / GCD) * val2);

            }
        }
        return res; 
    }

    private static int gcd(int x, int y){
        return (y == 0) ? x : gcd(y , x % y);
    }
}