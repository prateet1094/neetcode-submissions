class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                boolean res = dfs(i,j,word,0,board);
                if(res)return res;
            }
        }
        return false;
        
    }

    boolean dfs(int i, int j, String word, int idx,char[][]board){
        if(i>=board.length || j>=board[0].length || i<0 || j<0)return false;
        
        if(idx==word.length()-1){
            if(board[i][j]==word.charAt(idx))return true;
            return false;
        }

        char c = board[i][j];
        if(c!=word.charAt(idx))return false;

        boolean res = false;
        char org = board[i][j];
        board[i][j] = '-';
        res = dfs(i,j+1,word,idx+1,board);
        if(res)return true;


        res = dfs(i,j-1,word,idx+1,board);
        if(res)return true;
        res = dfs(i-1,j,word,idx+1,board);
        if(res)return true;
        res  = dfs(i+1,j,word,idx+1,board);
        
        board[i][j] = org;
        return res;
    }
}
