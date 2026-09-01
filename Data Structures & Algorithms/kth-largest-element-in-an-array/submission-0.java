class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a,b)->(b-a));
        for(int n:nums){
            pq.add(n);
            //if(pq.size()==k+1)pq.remove();
        }
        int res = 0;
        while(pq.size()>0 && k>0){
            res = pq.remove();
            k--;
        }
        return res;
        
    }
}
