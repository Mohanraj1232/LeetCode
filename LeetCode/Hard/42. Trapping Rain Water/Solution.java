class Solution {
    public int trap(int[] height) {
        if(height.length==1) return 0;
        int water_trapped=0;
        int prevmaxindex=0;
        int blocks=0;
        for(int i=1;i<height.length;i++){
            if(height[i]>=height[prevmaxindex]){
                water_trapped+=(((i-prevmaxindex-1)*height[prevmaxindex])-blocks);
                blocks=0;
                prevmaxindex=i;
            }else{
                blocks+=height[i];
            }
        }
        blocks=0;
        int newmaxindex=height.length-1;
        for(int i=newmaxindex-1;i>=prevmaxindex;i--){
            if(height[i]>=height[newmaxindex]){
                water_trapped+=(((newmaxindex-i-1)*height[newmaxindex])-blocks);
                blocks=0;
                newmaxindex=i;
            }else{
                blocks+=height[i];
            }
        }  
        return water_trapped;
    }
}