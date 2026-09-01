class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int k:stones){
            pq.add(k);
        }
        while(pq.size()>0){
            int max = pq.remove();
            if(pq.size()==0)return max;
            int smax = pq.remove();
            int diff = Math.abs(max-smax);
            if(diff==0)continue;
            else pq.add(diff);
        }
        return 0;
        
    }
}
