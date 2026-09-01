class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character,Integer> tset  = new HashMap<>();
        for(char c:t.toCharArray()){
            int currFreq = tset.getOrDefault(c,0);
            tset.put(c,1+currFreq);
        }
        int n = s.length();
        int i=0;
        HashMap<Character,Integer> sset  = new HashMap<>();
        int have = 0;
        int required = tset.size();
        int l = -1;
        int r = -1;
        int len = Integer.MAX_VALUE;
        for(int j=0;j<n;j++){
            char curr = s.charAt(j);
            int currFreq = sset.getOrDefault(curr,0);
            sset.put(curr,1+ currFreq);
            if(tset.containsKey(curr) && tset.get(curr)==sset.get(curr)){
                have++;
            }
            while(have==required){
                int currlen = j-i+1;
                if(currlen<len){
                    len = currlen;
                    l = i;
                    r = j;
                }
                int freq = sset.get(s.charAt(i));
                sset.put(s.charAt(i),freq-1);
                
                if(tset.containsKey(s.charAt(i)) && sset.get(s.charAt(i))<tset.get(s.charAt(i))){
                    have--;
                }
                i++;

            }
        }
        if(l!=-1){
            return s.substring(l,r+1);
        }
        return "";
        
    }
}
