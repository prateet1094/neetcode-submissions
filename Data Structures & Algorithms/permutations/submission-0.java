class Solution {
    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> zthIdx = new ArrayList<>(List.of(nums[0]));
        result.add(zthIdx);
        for(int i=1;i<nums.length;i++){
            int num = nums[i];
            List<List<Integer>> permutation = new ArrayList<>();
            for(int k=0;k<result.size();k++){
                List<Integer> prevPerm = result.get(k);
                
                for(int j=0;j<=prevPerm.size();j++){
                    List<Integer> perm = new ArrayList<>(prevPerm);
                    perm.add(j,num);
                    permutation.add(perm);
                }
            }
            result = permutation;
        }
        return result;
        
    }
}
