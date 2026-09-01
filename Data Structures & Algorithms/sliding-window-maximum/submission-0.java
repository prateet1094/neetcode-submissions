class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
            int[] result = new int[nums.length-k+1];
           Deque<Integer> deque = new ArrayDeque<>();
     
           int j=0;
           while(j<nums.length){
            while(deque.size()>0 && nums[deque.peekFirst()]<nums[j]){
                deque.removeFirst();
            }
            deque.addFirst(j);

            int winStartIndex = j-k+1;
            while(winStartIndex>=0 && deque.peekLast()<winStartIndex){
                deque.removeLast();
            }
            
            if(j-k+1>=0){
                result[j-k+1] = nums[deque.peekLast()];
            }
            j++;
           }
            return result; 
    }
}
