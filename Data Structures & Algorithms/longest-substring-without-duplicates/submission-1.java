class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0)return 0;
        int prev=0;
        int result = 1;
        HashMap<Character,Integer> map = new HashMap<>();
        map.put(s.charAt(0),0);
        for(int j=1;j<s.length();j++){
            char curr = s.charAt(j);
            if(map.containsKey(curr)){
                int prevReIndx = map.get(curr);
                prev = Math.max(prevReIndx+1,prev);
            } 
            result = Math.max(result,j-prev+1);
            map.put(curr,j);
        }
        return result;
        
    }
}
