class Solution {
    public int romanToInt(String s) {
        int num=0;
        for(int i=0; i<s.length(); i++){
            if(i+1 < s.length() && integerValueOfBool(s.substring(i, i+2))){
 
                num += integerValueOfString(s.substring(i, i+2));
                i+=1;
 
            } else {
                num += integerValueOfChar(s.charAt(i));
            }
        }
        return num;
    }
 
    public int integerValueOfString(String str){
 
        switch(str) {
            case "IV":
                return 4;
            case "IX":
                return 9;
            case "XL":
                return 40;
            case "XC":
                return 90;
            case "CD":
                return 400;
            case "CM":
                return 900;
        }
        return 0;
       
    }
 
    public int integerValueOfChar(char ch){
        switch(ch){
            case 'I' : return 1;
            case 'V' : return 5;
            case 'X' : return 10;
            case 'L' : return 50;
            case 'C' : return 100;
            case 'D' : return 500;
            case 'M' : return 1000;
        }
        return 0;
       
    }
 
    public boolean integerValueOfBool(String str){
        switch(str){
            case "IV" : return true;
            case "IX" : return true;
            case "XL" : return true;
            case "XC" : return true;
            case "CD" : return true;
            case "CM" : return true;
        }
        return false;
 
       
    }
 
}
