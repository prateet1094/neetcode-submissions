class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> set = new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
            if(set.containsKey(target-nums[i])){
                return new int[]{set.get(target-nums[i]),i};
            } else {
                set.put(nums[i],i);
            }
        }
        return new int[]{-1,-1};
    }
}
