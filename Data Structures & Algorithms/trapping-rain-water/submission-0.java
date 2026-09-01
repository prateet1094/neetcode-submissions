class Solution {
    public int trap(int[] height) {
        if(height.length==0)return 0;
        
        int result = 0;
        int leftMax = 0;
        int rightMax = 0;
        int i=0;
        int j=height.length-1;
        while(i<j){
            leftMax = Math.max(leftMax,height[i]);
            rightMax = Math.max(rightMax,height[j]);
            if(leftMax<=rightMax){
                result+=leftMax-height[i];
                i++;
            } else {
                 result+= rightMax-height[j];
                 j--;
            }
            
        }
        return result;
        
    }
}
