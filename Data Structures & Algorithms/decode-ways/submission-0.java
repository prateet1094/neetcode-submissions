class Solution {
    public int numDecodings(String s) {
        int len = s.length();
        int[]dp = new int[len+1];
        dp[len] = 1;
        for(int i=len-1;i>=0;i--){
            char ch  = s.charAt(i);
            int c = ch-'0'; 
            if(c!=0){

                if(i+1<=len){
                    dp[i] += dp[i+1];
                } 

                if(i+2<=len){
                    int kk = Integer.parseInt(s.substring(i,i+2));
                    if(kk<=26){
                        dp[i] += dp[i+2];
                    }  
                }
            }
        }

        return dp[0];
        
    }

}
