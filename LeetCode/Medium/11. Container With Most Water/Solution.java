class Solution {
    public int maxArea(int[] height) {
        int p1=0,p2=height.length-1;
        int res=0;

        while(p1<p2){
            int area=(p2-p1)*Math.min(height[p1],height[p2]);
            res=Math.max(area,res);

            if(height[p1]<height[p2]) p1++;
            else p2--;

        }

        return res;
    }
}
