class Solution {
    public List<List<String>> res = new ArrayList<>();
    public List<List<String>> partition(String s) {
        if(s.length()==0)return res;
        dfs(s,0,new ArrayList<>());
        return res;
    }
    public void dfs(String s, int idx,List<String> curr){
        if(idx==s.length()){
            res.add(new ArrayList<>(curr));
            return;
        }
        for(int i=idx+1;i<=s.length();i++){
            String currSubstring = s.substring(idx,i);
            if(isPalindrom(currSubstring)){
                curr.add(currSubstring);
                dfs(s,i,curr);
                curr.remove(curr.size()-1);
            }
        }
    }
    public Boolean isPalindrom(String s){
        int i = 0;
        int j = s.length()-1;
        while(i<j){
            if(s.charAt(i)!=s.charAt(j))return false;
            i++;
            j--;
        }
        return true;
    }
}
