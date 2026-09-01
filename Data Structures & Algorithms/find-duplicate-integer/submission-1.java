class Solution {
    // -1 3 -4 2 2
    public int findDuplicate(int[] nums) {
        for(int i=0;i<nums.length;i++){
            int original = Math.abs(nums[i]);
            if(nums[original-1]<0)return original;
            nums[original-1] = nums[original-1] * -1;

        }
        return -1;
    }
}
