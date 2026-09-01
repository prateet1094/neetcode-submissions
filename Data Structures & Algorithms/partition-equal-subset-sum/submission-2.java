class Solution {
    public boolean canPartition(int[] nums) {
        // if sum is odd then return false
        int sum = 0;
        for(int n:nums){
            sum += n;
        }
        if(sum%2!=0)return false;
        int targetSum = sum/2;
        return isSum(targetSum,nums);
        
    }

    public boolean isSum(int targetSum, int[]nums){
        boolean[][]dp = new boolean[nums.length][targetSum+1];
        for(int i=0;i<nums.length;i++){
            dp[i][0] = true;
        }
        dp[0][nums[0]] = true;
        for(int i=1;i<nums.length;i++){
            for(int j=1;j<=targetSum;j++){
                dp[i][j] = dp[i-1][j];
                if(j-nums[i]>=0){
                    dp[i][j] = dp[i-1][j-nums[i]] || dp[i][j];
                }
            }
        }
        return dp[nums.length-1][targetSum];

    }
}
