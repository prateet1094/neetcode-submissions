class Solution {
    public int rob(int[] nums) {
        if(nums.length==1)return nums[0];
        int first = 0;
        int second = 0;
        int temp1 = 0;
        for(int i=0;i<nums.length-1;i++){
            int temp = 0;
            if(i==nums.length-1){
                temp = Math.max(nums[i]+first,second);
            }
            temp = Math.max(nums[i]+first,second);
            first = second;
            second = temp;
        }
        temp1 = second;

        first = 0;
        second = 0;
        for(int i=1;i<nums.length;i++){
            int temp = 0;
            if(i==nums.length-1){
                temp = Math.max(nums[i]+first,second);
            }
            temp = Math.max(nums[i]+first,second);
            first = second;
            second = temp;
        }
        return Math.max(second,temp1);
        
    }
}
