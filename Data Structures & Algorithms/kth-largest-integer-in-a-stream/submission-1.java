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
         pq.add(val);
        if(pq.size()>k){
            pq.remove();
        } 
        return pq.peek();
    }
}
