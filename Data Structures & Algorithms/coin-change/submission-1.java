class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount==0)return 0;
        int[]dp = new int[amount+1];
        dp[0] = 0;
        for(int i=1;i<=amount;i++){
            dp[i] = Integer.MAX_VALUE-1;
            for (int j=0;j<coins.length;j++){
                if(coins[j]<=i){
                    int left = i-coins[j];
                    dp[i] = Math.min(dp[i],dp[i-coins[j]]+1);
                    
                }
            }
        }
        return dp[amount]==(Integer.MAX_VALUE-1)?-1:dp[amount];
        
    }
}
