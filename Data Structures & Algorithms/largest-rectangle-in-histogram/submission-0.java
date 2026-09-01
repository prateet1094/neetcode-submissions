class Solution {
    public int largestRectangleArea(int[] heights) {
         Stack<Integer> stack = new Stack<>();
        int[] leftB = new int[heights.length];
        int[] rightB = new int[heights.length];
        for(int i=0;i<heights.length;i++){
            while(!stack.isEmpty() && heights[stack.peek()]>=heights[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                leftB[i] = -1;
            } else {
                leftB[i] = stack.peek();
            }
            stack.push(i);
        }

        // left 0, 1,2
        // right  2,2
        stack.clear();
        for(int i=heights.length-1;i>=0;i--){
            while(!stack.isEmpty() && heights[stack.peek()]>=heights[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                rightB[i] = heights.length;
            } else {
                rightB[i] = stack.peek();
            }
            stack.push(i);
        }
        int result = 0;
        for(int i=0;i<heights.length;i++){
            leftB[i] += 1;
            rightB[i] -= 1;
            result = Math.max(result,heights[i]*(rightB[i]-leftB[i]+1));
        }
        return result;
    }
}
