class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0)return 0;
        Set<Integer> set = new HashSet<Integer>();
        for(int num:nums){
            set.add(num);
        }
        int result = 1;
        for(int num:nums){
            if(!set.contains(num-1)){
                int curr = num;
                int temp = 1;
                while(set.contains(curr+1)){
                    temp++;
                    curr++;
                }
                if(temp>result){
                    result = temp;
                }
            }
        }
        return result;
    }
}


