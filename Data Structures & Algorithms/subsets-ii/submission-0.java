class Solution {
    public List<List<Integer>> res  = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        dfs(nums,0,new ArrayList<Integer>());
        return res;
    }
    public void dfs(int[]nums,int idx,List<Integer> curr){
        if(idx==nums.length){
            res.add(new ArrayList<>(curr));
            return;
        }
        curr.add(nums[idx]);
        dfs(nums,idx+1,curr);
        curr.remove(curr.size()-1);

        while((idx+1)<nums.length && nums[idx]==nums[idx+1])idx++;
        dfs(nums,idx+1,curr);
    }
}
