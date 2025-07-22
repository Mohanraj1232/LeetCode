class Solution {
    public boolean searchMatrix(int[][] m, int target) {
        for(int i=0;i<m.length;i++){
            if(target==m[i][(m[0].length)-1]) return true;
            else if(target<m[i][(m[0].length)-1]){
                for(int j=0;j<(m[0].length)-1;j++){
                    if(target==m[i][j]) return true;
                }
                return false;
            }
        }
        return false;
    }
}
