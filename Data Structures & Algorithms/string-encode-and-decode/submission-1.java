class Solution {

    public String encode(List<String> strs) {
        StringBuilder s = new StringBuilder();
        for(String str : strs){
            int count = str.length();
            s.append(count).append('#').append(str);
        }
        return s.toString();

    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<String>();
        int idx = 0;
        // string str: 5#Hello5#World
        while(idx<str.length()){
            int j = idx;
            while(str.charAt(j)!='#'){
                j++;
            }
            int length = Integer.parseInt(str.substring(idx,j));
             idx = j+1;
             j = idx+length;
             result.add(str.substring(idx,j)); 
             idx = j;
        }
        return result;


    }
}
