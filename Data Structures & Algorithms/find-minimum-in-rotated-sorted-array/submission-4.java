class Solution {
    // 6 1 2
    public int findMin(int[] nums) {
         int left = 0;
        int right = nums.length-1;
        int result = nums[0];
        while(left<=right){
            if(nums[left]<nums[right]){
                result = nums[left];
                break;
            }
            int mid = left+(right-left)/2;
            result = Math.min(result,nums[mid]);
            if(nums[left]<=nums[mid])left = mid+1;
            else right = mid;
        }
        return result;
    }
}
