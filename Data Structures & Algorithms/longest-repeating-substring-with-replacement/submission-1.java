class Solution {
    public int characterReplacement(String s, int k) {
        int i = 0;
        int j = 0;
        int[]count = new int[26];
        int result = 0;
        while(j<s.length()){
            count[s.charAt(j)-'A']++;
            int length = j-i + 1;
            int maxF = 0;
            
            for(int r:count)maxF = Math.max(r,maxF);
            if(length-maxF <= k){
                 result = Math.max(result,length);
                j++;
            } else {
                count[s.charAt(j)-'A']--;
                count[s.charAt(i)-'A']--;
                i++;
            }
        }
        return result;
    }
}
