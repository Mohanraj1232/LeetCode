class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        int max=0,len=0;

        for(int i=0;i<s.length();i++){
            if(map.get(s.charAt(i))!=null){
                max=Math.max(len,max);
                len=1;
                map.clear();
                map.put(s.charAt(i),1);
            }else{
                len++;
                map.put(s.charAt(i),1);
            }
        }
        return Math.max(len,max);
    }
}