class Solution {
    public String longestPalindrome(String s) {
        int maxlen = 0;
        int res = 0;
        int n = s.length();
        for(int i=0;i<n;i++){
            int left = i;
            int right = i;
            while(right<n && left>=0 && s.charAt(left)==s.charAt(right)){
                if(right-left+1>maxlen){
                    maxlen = right-left+1;
                    res = left;
                }

                left--;
                right++;
            }
            left = i;
            right = i+1;
            while(right<n && left>=0 && s.charAt(left)==s.charAt(right)){
                if(right-left+1>maxlen){
                    maxlen = right-left+1;
                    res = left;
                }

                left--;
                right++;
            }
        }
        return s.substring(res,res+maxlen);
    }
}
