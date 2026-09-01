class Solution {
    public boolean isAnagram(String s1,String s2){
        HashMap<Character,Integer> map1 = new HashMap<>();
        HashMap<Character,Integer> map2 = new HashMap<>();

        for(char c:s1.toCharArray()){
            int curr = map1.getOrDefault(c,0);
            map1.put(c,1+curr);
        }
        for(char c:s2.toCharArray()){
            int curr = map2.getOrDefault(c,0);
            map2.put(c,1+curr);
        }
        return map1.equals(map2);
    }
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length())return false;
        int n  = s1.length();
        for(int i=n-1;i<s2.length();i++){
            String curr = s2.substring(i-n+1,i+1);
            if(isAnagram(curr,s1))return true;
        }
        return false;
        
    }
}
