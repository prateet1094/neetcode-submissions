class Solution {
    public String longestPalindrome(String s) {
        
        int n = s.length();
        if(n==1)return s;
        boolean[][]isPalindrome = new boolean[n][n];
        int m =0;
        int k = 0;
        int maxLen = 1;

        for(int i=0;i<n;i++){
            isPalindrome[i][i] = true;
        }
        for(int len=2;len<=n;len++){
            for(int i=0;i<n;i++){
                int j = i+len-1;
                if(j>=n)continue;
                boolean gh = len<=3 ||isPalindrome[i+1][j-1] ;
     

                if(gh && s.charAt(i)==s.charAt(j)){
                    isPalindrome[i][j] = true;
                    if(len>maxLen){
                        maxLen = len;
                        m = i;
                    }
                }
            }
        }
        return s.substring(m,m+maxLen);
        
    }
}
