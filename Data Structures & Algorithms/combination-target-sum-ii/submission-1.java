class Solution {
    public static  List<List<Integer>> result = new ArrayList<>(); 
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        result.clear();
        Arrays.sort(candidates);
         dfs(candidates,0,0,new ArrayList<Integer>(),target);
        return result;
    }
    public void dfs(int[]candidates, int idx, int sumSoFar,List<Integer> curr,int target){
        if(sumSoFar>target)return;
        if(sumSoFar==target){
            result.add(new ArrayList<>(curr));
            return;
        }
        if(idx>=candidates.length)return;
      
            // choose
            curr.add(candidates[idx]);
            dfs(candidates,idx+1,sumSoFar+candidates[idx],curr,target);
            curr.remove(curr.size()-1);
        
        // dont select
        while((idx+1)<candidates.length && candidates[idx]==candidates[idx+1])idx++;
        dfs(candidates,idx+1,sumSoFar,curr,target);

    }
}
