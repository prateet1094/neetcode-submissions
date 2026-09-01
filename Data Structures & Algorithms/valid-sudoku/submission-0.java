class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] box = new boolean[9][9];

        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]=='.') continue;
                int n = board[i][j]-'1' + 1;

                if(rows[i][n-1])return false;
                rows[i][n-1] = true;

                if(cols[j][n-1])return false;
                cols[j][n-1] = true;

                int boxidx = (i/3)*3 + j/3;

                if(box[boxidx][n-1])return false;
                box[boxidx][n-1] = true;

            }
        }
        return true;

    }
}
