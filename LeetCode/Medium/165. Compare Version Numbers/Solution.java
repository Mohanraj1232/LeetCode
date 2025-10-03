class Solution {
    public int compareVersion(String version1, String version2) {
        int l1 = version1.length() ,l2 = version2.length();
        int v1 = 0, v2 = 0;
        int p1 = 0 ,p2 = 0;

        while(p1 < l1 || p2 < l2){
            while(p1 < l1 && version1.charAt(p1) != '.') {
                v1 = v1 * 10 + (version1.charAt(p1) - '0');
                p1++;
            }
            while(p2 < l2 && version2.charAt(p2) != '.') {
                v2 = v2 * 10 + (version2.charAt(p2) - '0');
                p2++;
            }
            if(v1 < v2){
                return -1;
            }else if(v2 < v1){
                return 1;
            }
            if(p1 == l1 && p2 == l2){
                return 0;
            }
            p1++;
            p2++;
            v1 = 0;
            v2 = 0;
        }

        return 0;
    }
}