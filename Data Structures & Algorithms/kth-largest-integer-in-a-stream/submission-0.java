class KthLargest {
    PriorityQueue<Integer> pq ;
    int k;

    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<>();
        this.k = k;
        for(int n:nums){
            add(n);
        }
    }
    
    public int add(int val) {
        if(pq.size()<k){
            pq.add(val);
        } else {
            if(pq.peek()<val){
                pq.remove();
                pq.add(val);
            }
        }
        return pq.peek();
    }
}
