class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result  = new ArrayList<>();
        subsets(nums,0,result);
        return result;
    }
    public void subsets(int[] nums,int startIndex,List<List<Integer>> result) {
        if(startIndex==nums.length){
            result.add(new ArrayList<>());
            return;
        }
        subsets(nums,startIndex+1,result);
        int size  = result.size();
        for(int i=0;i<size;i++){
             List<Integer> copy = new ArrayList<>(result.get(i));
             copy.add(nums[startIndex]);
             result.add(copy);
        }
    }

}
