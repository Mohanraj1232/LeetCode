class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character,Integer> map=new HashMap<>();

        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        int res=0;
        boolean isoddPresent=false;
        for(char key:map.keySet()){
            int val=map.get(key);
            if(val%2==0){
                res+=val;
            }else{
                isoddPresent=true;
                res+=(val-1);
            }
        }
        return (isoddPresent)?res+1:res;
    }
}
