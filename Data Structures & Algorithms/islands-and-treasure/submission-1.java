class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==0){
                    queue.add(new int[]{i,j});
                }
            }
        }
        int[] dRow = {-1, 1, 0, 0};
        int[] dCol = { 0, 0, -1, 1};
        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            int m = curr[0];
            int n = curr[1];
            
            for (int k = 0; k < 4; k++) {
                int nextRow = m + dRow[k];
                int nextCol = n + dCol[k];

                if(nextRow>=0 && nextRow<grid.length && nextCol>=0 && nextCol<grid[0].length 
                && grid[nextRow][nextCol]==2147483647 ){
                    grid[nextRow][nextCol] = 1 + grid[m][n];
                    queue.add(new int[]{nextRow,nextCol});
                }
             }
        }
    }
   
}
