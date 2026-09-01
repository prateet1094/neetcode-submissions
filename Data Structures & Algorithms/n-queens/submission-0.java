class Solution {
    public List<List<String>> solveNQueens(int n) {
        boolean blockedCol[] = new boolean[n];
        boolean blockedDiagL[] = new boolean[2*n-1];
        boolean blockedDiagR[] = new boolean[2*n-1];

        List<List<String>> res = new ArrayList<>();
        

        dfs(0,n,blockedCol,blockedDiagL,blockedDiagR,res,new ArrayList<String>());
        
        return res;
        
    }
    public void dfs(int idx,int n, boolean blockedCol[], 
    boolean blockedDiagL[],boolean blockedDiagR[], List<List<String>> res,List<String> rowSoFar){

        if(idx==n){
            res.add(new ArrayList<>(rowSoFar));
            return;
        }
        StringBuilder placement  = new StringBuilder();
        for(int i=0;i<n;i++){
            placement.append(".");
        }

        for(int i=0;i<n;i++){
            // Try placing queen at ith idx
            int diagLIdx = i+idx; // to be think
            int diagRIdx = idx-i+n-1; // to be think
            if(blockedCol[i] || blockedDiagL[diagLIdx] || blockedDiagR[diagRIdx])continue;

            blockedCol[i] = true;
            blockedDiagR[diagRIdx] = true;
             blockedDiagL[diagLIdx] = true;
            placement.setCharAt(i, 'Q'); 
            rowSoFar.add(placement.toString());
            dfs(idx+1,n,blockedCol,blockedDiagL,blockedDiagR,res,rowSoFar);
            placement.setCharAt(i, '.'); 
            rowSoFar.remove(rowSoFar.size()-1);

            blockedCol[i] = false;
            blockedDiagL[diagLIdx] = false;
            blockedDiagR[diagRIdx] = false;
        }

    }
}
