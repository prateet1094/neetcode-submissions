class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<Integer> curr = new ArrayList<Integer>();
        List<List<Integer>> result = new ArrayList<>();
        combinationSum(nums,target,0,curr,result);
        return result;
    }

    public void combinationSum(int[] nums, int target, int i,List<Integer> curr, List<List<Integer>> result) {
        if(target<0)return ;
        if(target==0){
            result.add(new ArrayList<Integer>(curr));
            return;
        }
       
            // include n
            curr.add(nums[i]);
            int idx  = curr.size();
            combinationSum(nums,target-nums[i],i,curr,result);
            curr.remove(idx-1);

            // exclude n
            if(i+1<nums.length)
            combinationSum(nums,target,i+1,curr,result);
        
    }
}
