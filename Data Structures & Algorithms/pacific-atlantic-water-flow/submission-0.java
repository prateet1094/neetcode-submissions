class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        boolean[][] pacific = new boolean[heights.length][heights[0].length];
        boolean[][] atlantic = new boolean[heights.length][heights[0].length];

        for(int j=0;j<heights[0].length;j++){
            dfs(0,j,pacific,heights[0][j],heights);
            dfs(heights.length-1,j,atlantic,heights[heights.length-1][j],heights);
        }

        for(int i=0;i<heights.length;i++){
            dfs(i,0,pacific,heights[i][0],heights);
            dfs(i,heights[0].length-1,atlantic,heights[i][heights[0].length-1],heights);
        }
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0;i<heights.length;i++){
            for(int j=0;j<heights[0].length;j++){

                if(pacific[i][j] && atlantic[i][j]){
                    List<Integer> sol = new ArrayList<>();
                    sol.add(i);
                    sol.add(j);
                    result.add(sol);
                }
            }
        }
        return result;
    }
    public void dfs(int i, int j, boolean[][]sea,int ht,int[][] heights){
        if(i<0 || j<0 || i>=sea.length || j>=sea[0].length  || sea[i][j] || heights[i][j]<ht)return;

        sea[i][j] = true;
        dfs(i+1,j,sea,heights[i][j],heights);
        dfs(i-1,j,sea,heights[i][j],heights);
        dfs(i,j+1,sea,heights[i][j],heights);
        dfs(i,j-1,sea,heights[i][j],heights);

    }
}
