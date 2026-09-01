class Solution {
    public int maxProfit(int[] prices) {
        int sellMax = Integer.MIN_VALUE;
        int result = 0;
        for(int i=prices.length-1;i>=0;i--){
            if(i==prices.length-1){
                sellMax = prices[i];
                continue;
            } 
            result = Math.max(result,sellMax-prices[i]);
            sellMax = Math.max(sellMax,prices[i]);
        }
        return result;
        
    }
}
