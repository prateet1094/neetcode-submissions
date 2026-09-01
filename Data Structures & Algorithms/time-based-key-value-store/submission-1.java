class TimeMap {

    public class Entry {
        int timestamp;
        String value;

        public Entry(int timestamp,String value){
            this.timestamp = timestamp;
            this.value = value;
        }
    }
    Map<String,List<Entry>> dict;
    public TimeMap() {
        dict = new HashMap<String,List<Entry>>();
    }
    
    public void set(String key, String value, int timestamp) {
        Entry entry = new Entry(timestamp,value);
        if(!dict.containsKey(key)){
            dict.put(key,new ArrayList<Entry>());
        } 
        dict.get(key).add(entry);
    }
    // 1 2 3 5 7 9 10 11 12 13 14
    // timestamp 6
    public String get(String key, int timestamp) {
        if(!dict.containsKey(key))return "";
        List<Entry> list = dict.get(key);

        int left = 0;
        int right = list.size()-1;
        String result = "";
        while(left<=right){
            int mid = left + (right-left)/2;

            if(timestamp < list.get(mid).timestamp){
                right = mid- 1;
            } else {
                left = mid+1;
                result = list.get(mid).value;
            }
        }
        return result;
        
    }
}
