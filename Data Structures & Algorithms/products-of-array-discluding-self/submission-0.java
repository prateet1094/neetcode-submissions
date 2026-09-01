class Solution {
    public int[] productExceptSelf(int[] nums) {

        if(nums.length==0)return new int[0];
        if(nums.length==1)return new int[]{nums[0]};
        if(nums.length==2)return new int[]{nums[1],nums[0]};
        int[] fwd = new int[nums.length];
        int[] bwd = new int[nums.length];
        int[] result = new int[nums.length];

        fwd[0] = 1;
        bwd[nums.length-1] = 1;
        result[0] = 1;
        result[result.length-1] = 1;

        for(int i=1;i<nums.length;i++){
            fwd[i] = nums[i-1]*fwd[i-1];
            result[i] = fwd[i];
        }
        for(int i=nums.length-2;i>=0;i--){
            bwd[i] = bwd[i+1]*nums[i+1];
            result[i] = result[i]*bwd[i];
        }
        return result;


    }
}  
