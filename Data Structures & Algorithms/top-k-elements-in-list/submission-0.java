class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        List<Integer>[] arr = new ArrayList[nums.length];
        Map<Integer,Integer> freq = new HashMap<Integer,Integer>();
        for(int num:nums){
            if(freq.containsKey(num)){
                int fr = freq.get(num);
                freq.put(num,1+fr);
            } else {
                freq.put(num,1);
            }
        }
        for(int num :freq.keySet()){
            int count = freq.get(num);
            if(arr[count-1]==null){
                arr[count-1] = new ArrayList<>();
            }
            arr[count-1].add(num);
        }
        int[] result = new int[k];
        int idx = 0;
        for(int i=nums.length-1;i>=0 && idx<k;i--){
            if(arr[i]!=null && arr[i].size()>0){
                for(int topk:arr[i]){
                    result[idx] = topk;
                    idx++;
                    if(idx==k)break;
                }
            }
        }
        return result;
        
    }
}
