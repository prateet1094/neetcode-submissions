class Solution {
    public int minCostClimbingStairs(int[] cost) {
        if(cost.length==1)return cost[0];
        if(cost.length==2)return Math.min(cost[0],cost[1]);

        int[]dp = new int[cost.length+1];
        dp[0] = 0;
        dp[1] = 0;

        for(int i=2;i<=cost.length;i++){
            int j1 = dp[i-1] + cost[i-1];
            int j2 = dp[i-2] + cost[i-2];
            dp[i] = Math.min(j1,j2);
        }
        return dp[dp.length-1];
        
    }
}
