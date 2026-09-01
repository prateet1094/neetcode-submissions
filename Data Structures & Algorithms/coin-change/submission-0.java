class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount==0)return 0;
        int[]dp = new int[amount+1];
        dp[0] = 0;
        for(int i=1;i<=amount;i++){
            dp[i] = Integer.MAX_VALUE;
            for (int j=0;j<coins.length;j++){
                int val = coins[j];
                if(val<=i){
                    int left = i-val;
                    if(left==0){
                        dp[i] = 1;
                    }
                    else if(dp[left] != Integer.MAX_VALUE){
                        dp[i] = Math.min(dp[i],dp[left]+1);
                    } 
                }
            }
        }
        return dp[amount]==Integer.MAX_VALUE?-1:dp[amount];
        
    }
}
