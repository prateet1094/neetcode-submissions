class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character,Integer> mapS = new HashMap<Character,Integer>();
        for(char c : s.toCharArray()){
            if(mapS.containsKey(c)){
                mapS.put(c,mapS.get(c)+1);
            } else {
                mapS.put(c,1);
            }
        }
        HashMap<Character,Integer> mapT = new HashMap<Character,Integer>();
        for(char c : t.toCharArray()){
            if(mapT.containsKey(c)){
                mapT.put(c,mapT.get(c)+1);
            } else {
                mapT.put(c,1);
            }
        }
        return mapT.equals(mapS);

    }
}
