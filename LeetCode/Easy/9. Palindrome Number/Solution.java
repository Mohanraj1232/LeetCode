class Solution {
    public boolean isPalindrome(int x) {
        int sum=0;
        if(x<0) return false;
        else{
            int s=x;
            while(s!=0){
                sum=sum*10+s%10;
                s=s/10;
            }
        }
        if(x==sum) return true;
        return false;
    }
}