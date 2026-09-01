class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Map<Character,Integer>,List<String>> map = new HashMap<>();
        for(String str:strs){
            Map<Character,Integer> freqMap = GetFreqMap(str);
            if(map.containsKey(freqMap)){
                List<String> list = map.get(freqMap);
                list.add(str);
                map.put(freqMap,list);
            } else{
                map.put(freqMap,new ArrayList<>(Arrays.asList(str)));
            }
        }
        return map.values().stream().collect(Collectors.toList());
    }

    public Map<Character,Integer> GetFreqMap(String str){
        Map<Character,Integer> freqMap = new HashMap<Character,Integer>();
        for(char c: str.toCharArray()){
            if(freqMap.containsKey(c)){
                freqMap.put(c,freqMap.get(c)+1);
            } else {
                freqMap.put(c,1);
            }
        }
        return freqMap;
    }
}
