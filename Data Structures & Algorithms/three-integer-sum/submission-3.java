class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result  = new ArrayList<>();
        Arrays.sort(nums);
        // -2 0 0 2 2 
        for(int i=0;i<nums.length;i++){
            int target = -1*nums[i];
            int j=i+1;
            int k = nums.length-1;
            if(i>0 && nums[i-1]==nums[i])continue;
            
            while(j<k){
                
                if(nums[j]+nums[k]==target){
                    List<Integer> subList = new ArrayList<>();
                    subList.add(nums[i]);
                    subList.add(nums[j]);
                    subList.add(nums[k]);
                    result.add(subList);
                    if(j<nums.length-1 && nums[j]==nums[j+1])j++;
                    j++;
                    k--;
                    if(j<nums.length && nums[j]==nums[j-1])j++;
                    if(k>=0&& nums[k]==nums[k+1])k--;

                } else if(nums[j]+nums[k]>target) {
                    k--;
                } else {
                    j++;
                }
            }
            
        }
        return result;
    }
}
