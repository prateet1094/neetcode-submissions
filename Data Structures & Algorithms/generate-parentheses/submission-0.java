class Solution {
    public List<String> result;
    public List<String> generateParenthesis(int n) {
        result = new ArrayList<>();
        dfs(n,n,0,0,"");
        return result;
    }

    public void dfs(int openAvailable, int closeAvailable, int openedSoFar,int closedSoFar, String stringSoFar){
        if(openAvailable==closeAvailable && closeAvailable==0){
            if(!stringSoFar.isEmpty()){
            result.add(stringSoFar);
            }
            return;
        }

        if(openAvailable>0){
            stringSoFar = stringSoFar + '(';
            dfs(openAvailable-1,closeAvailable,openedSoFar+1,closedSoFar,stringSoFar );
            stringSoFar = stringSoFar.substring(0,stringSoFar.length()-1);
        }
        if(openedSoFar>closedSoFar){
            stringSoFar = stringSoFar + ')';
            dfs(openAvailable,closeAvailable-1,openedSoFar,closedSoFar+1,stringSoFar );
            stringSoFar = stringSoFar.substring(0,stringSoFar.length()-1);
        }

    }
}
