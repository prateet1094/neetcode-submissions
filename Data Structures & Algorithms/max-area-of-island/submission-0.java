class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int result = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 1){
                    result = Math.max(bfs(i,j,grid),result);
                }
            }
        }
        return result;
    }
    public int bfs(int i, int j, int[][]grid){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length){
            return 0;
        }
        if(grid[i][j]==0)return 0;
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{i,j});
        int res = 0;
        while(!que.isEmpty()){
            int[] curr = que.poll();
            int m = curr[0];
            int n = curr[1];
            if(m>=0 && n>=0 && m<grid.length 
            && n<grid[0].length && grid[m][n]==1){
                grid[m][n]=0;
                que.add(new int[]{m+1,n});
                que.add(new int[]{m,n+1});
                que.add(new int[]{m,n-1});
                que.add(new int[]{m-1,n});

                res++;
            }
            
        }
        return res;
    }
}
