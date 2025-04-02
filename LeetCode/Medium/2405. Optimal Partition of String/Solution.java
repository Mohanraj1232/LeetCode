class Solution {
    public int partitionString(String s) {
        long val= 0;
        int res=1;
        for(int i=0;i<s.length();i++){
            int dig=s.charAt(i)-'a';

            if((val&(1<<dig))!=0){
                val=0;
                val|=(1<<dig);
                res++;
            }else{
                val|=(1<<dig);
            }
        }

        return res;
    }
}