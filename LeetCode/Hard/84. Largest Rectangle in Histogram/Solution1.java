
class Solution1 {
    public int largestRectangleArea(int[] heights) {
        int N = heights.length , res = 0;

        int []left = monotonicLeft(heights ,N);
        int []right = monotonicRight(heights ,N);

        for(int i = 0 ; i < N ; i++){
            int widthLeft = i - (left[i] + 1);
            int widthRight = (right[i] - 1) - i;

            int width = widthLeft + 1 + widthRight;

            res = Math.max(res ,heights[i] * width);
        }

        return res;
    }

    private int[] monotonicLeft(int arr[] ,int N){
        int res[] = new int[N];
        Stack<Integer> stack = new Stack<>();

        for(int i = 0 ; i < N ; i++){
            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]) stack.pop();

            if(stack.isEmpty())
                res[i] = -1;
            
            else
                res[i] = stack.peek();
            
            stack.push(i);
        }

        return res;
    }

    private int[] monotonicRight(int arr[] ,int N){
        int res[] = new int[N];
        Stack<Integer> stack = new Stack<>();

        for(int i = N - 1 ; i >= 0 ; i--){
            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]) stack.pop();

            if(stack.isEmpty())
                res[i] = N;
            
            else
                res[i] = stack.peek();
            
            stack.push(i);
        }

        return res;
    }

}