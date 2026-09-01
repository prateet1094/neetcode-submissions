class Solution {
    public int numIslands(char[][] grid) {
        int result = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(dfs(i,j,grid)){
                    result++;
                }
            }
        }
        return result;
    }

    public boolean dfs(int i,int j,char[][]grid){
        if(i< 0 || j<0 || i>=grid.length || j>=grid[0].length){
            return false;
        }
        if(grid[i][j]=='0' || grid[i][j]=='#')return false;

        grid[i][j] = '#';
        dfs(i+1,j,grid);
        dfs(i,j+1,grid);
        dfs(i,j-1,grid);
        dfs(i-1,j,grid);
        return true;

    }
}
