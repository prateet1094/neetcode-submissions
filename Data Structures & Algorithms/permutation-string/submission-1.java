class Solution {
    
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length())return false;
        int[]count1 = new int[26];
        int[]count2 = new int[26];
        int n = s1.length();
        int matches = 0;
        for(int i=0;i<n;i++){
            count1[s1.charAt(i)-'a']++;
            count2[s2.charAt(i)-'a']++;
        }
        for(int i=0;i<26;i++){
            if(count1[i]==count2[i])matches++;
        }
        int l=0;
        for(int i=n;i<s2.length();i++){
            if(matches==26)return true;
            count2[s2.charAt(i)-'a']++;
            if(count2[s2.charAt(i)-'a']==count1[s2.charAt(i)-'a']){
                matches++;
            } else if(count2[s2.charAt(i)-'a']-1==count1[s2.charAt(i)-'a']){
                matches--;
            }

            count2[s2.charAt(l)-'a']--;
            if(count2[s2.charAt(l)-'a']==count1[s2.charAt(l)-'a']){
                matches++;
            } else if(count2[s2.charAt(l)-'a']+1==count1[s2.charAt(l)-'a']){
                matches--;
            }
            l++;

        }
        return matches==26;

        
    }
}
