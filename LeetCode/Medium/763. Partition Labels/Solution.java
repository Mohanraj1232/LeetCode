class Solution {
    public List<Integer> partitionLabels(String s) {
        ArrayList<Integer> res=new ArrayList<>();
        int []fre=new int[26];
        int len=0,n=s.length();
        Set<Character> set=new HashSet<>();


        for(int i=0;i<n;i++){
            fre[s.charAt(i)-'a']++;
        }

        for(int i=0;i<n;i++){
            if(--fre[s.charAt(i)-'a']==0){
                set.remove(s.charAt(i));
                if(set.isEmpty()){
                    len++;
                    res.add(len);
                    len=0;
                }else{
                    len++;
                }
            }else{
                set.add(s.charAt(i));
                len++;
            }
        }
        
        return res;
    }
}