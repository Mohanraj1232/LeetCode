class Solution {
    public int largestRectangleArea(int[] heights) {
        int N = heights.length , res = 0;
        Stack<Integer> stack = new Stack<>();

        for(int i = 0 ; i <= N ; i++){
            int height = (i == N) ? 0 : heights[i];

            while(!stack.isEmpty() && heights[stack.peek()] >= height){
                int curHeight = heights[stack.pop()] , width;
                
                if(stack.isEmpty())
                    width = i;
                else
                    width = i - stack.peek() - 1;

                res = Math.max(res ,width * curHeight);
            }
            stack.push(i);
        }

        return res;
    }

}

