class Solution {
    public int myAtoi(String s) {
        s= s.replaceFirst("^\\s+", "");
        if(s.equals("")) return 0;
        boolean flag;
        int i=0;
        long ans=0;
        if(s.charAt(0)=='-'){ 
            flag=true;
            i=1;
        }
        else if(s.charAt(0)=='+'){
            flag=false;
            i=1;
        }else{
            flag=false;
            i=0;
        }
        while(i<s.length() && Character.isDigit(s.charAt(i))){
            ans=ans*10+(s.charAt(i)-'0');
            if(ans>2147483647){
                if(flag) return  -2147483648;
                else return 2147483647;
            }
            i++;
        }
        ans=(flag)?ans*-1:ans;
        return (int)ans;
    }
}
