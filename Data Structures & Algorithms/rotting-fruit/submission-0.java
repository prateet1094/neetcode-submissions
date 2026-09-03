class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2){
                    q.add(new int[]{i,j});
                }
                
            }
        }
        int dRows[] = new int[]{0,0,1,-1};
        int dCols[] = new int[]{1,-1,0,0};
        int result = 0;
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                int[]curr = q.poll();
                for(int j=0;j<4;j++){
                    
                    int nbrRow = curr[0]+ dRows[j];
                    int nbrCol = curr[1] + dCols[j];

                    if(nbrRow>=0 && nbrRow<grid.length && nbrCol>=0 && nbrCol<grid[0].length && grid[nbrRow][nbrCol]==1){
                        grid[nbrRow][nbrCol]=2;
                        q.add(new int[]{nbrRow,nbrCol});
                    }

                }
            }
            if(q.size()>0){
                result++;
            }

        }
        // Check if any fresh orange remains
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }

        return result;
        
    }
}
