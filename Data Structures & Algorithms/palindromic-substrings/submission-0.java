class Solution {
    public int countSubstrings(String s) {
        int res = 0;
        int n = s.length();
        for(int i=0;i<n;i++){
            int left = i;
            int right = i;
            while(right<n && left>=0 && s.charAt(left)==s.charAt(right)){
                res++;

                left--;
                right++;
            }
            left = i;
            right = i+1;
            while(right<n && left>=0 && s.charAt(left)==s.charAt(right)){
               res++;

                left--;
                right++;
            }
        }
        return res;
    }
}
