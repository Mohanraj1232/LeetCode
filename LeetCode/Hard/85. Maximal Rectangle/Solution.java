class Solution {
    public int maximalRectangle(char[][] matrix) {

        int R = matrix.length , C = matrix[0].length , res = 0;

        int heights[] = new int[C];

        for(int r = 0 ; r < R ; r++){
            for(int c = 0 ; c < C ; c++){
                heights[c] = (matrix[r][c] == '0') ? 0 : heights[c] + 1;
            }
            res = Math.max(res ,largestRectangleArea(heights));
        }

        return res;
    }

    private int largestRectangleArea(int[] heights) {
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