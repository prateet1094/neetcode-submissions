class Solution {
    public boolean canPartition(int[] nums) {
        // if sum is odd then return false
        int sum = 0;
        for(int n:nums){
            sum += n;
        }
        if(sum%2!=0)return false;
        int targetSum = sum/2;
        return isSum(targetSum,nums);
        
    }

    public boolean isSum(int targetSum, int[]nums){
        boolean[]prev = new boolean[targetSum+1];
        boolean[]curr = new boolean[targetSum+1];
        prev[0] = true;
        if(nums[0]<=targetSum){
            prev[nums[0]] = true;
        }
        curr[0] = true;
        for(int i=1;i<nums.length;i++){
            for(int j=1;j<=targetSum;j++){
                curr[j] = prev[j];
                if(j-nums[i]>=0){
                    curr[j] = prev[j-nums[i]] || prev[j];
                }
            }
            boolean[] temp = prev;
            prev = curr;
            curr = temp;

        }
        return prev[targetSum];

    }
}
