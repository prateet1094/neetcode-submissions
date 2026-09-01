class Solution {
    public int maxArea(int[] heights) {
        int i=0;
        int j = heights.length-1;
        int result = 0;
        while(i<j){
            result = Math.max(result,Math.min(heights[i],heights[j])*(j-i));
            if(heights[i]>=heights[j]){
                j--;
            } else {
                i++;
            }
        }
        return result;
    }
}
