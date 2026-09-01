class Solution {
    public int lengthOfLIS(int[] nums) {
        int[]dp = new int[nums.length];
        int res = 1;
        dp[0] = 1;
        for(int i=1;i<nums.length;i++){
            dp[i] = 1;
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i]){
                    dp[i] = Math.max(dp[i],1+dp[j]);
                }
            }
            res = Math.max(res,dp[i]);
        }
        return res;
        
        
    }
}
