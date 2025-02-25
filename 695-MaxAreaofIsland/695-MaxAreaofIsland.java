class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        boolean[][] vis = new boolean[grid.length][grid[0].length];

        int max = 0;

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1 && !vis[i][j]){
                    max=Math.max(max,dfs(grid,i,j,vis,0));
                }
            }
        }

        return max;
    }

    public int dfs(int[][] grid, int r, int c, boolean[][] vis, int count){
        vis[r][c] = true;

        count++;

        int[] row = {0,1,0,-1};
        int[] col = {1,0,-1,0};

        for(int i=0;i<4;i++){
            if(isValid(grid,vis,r+row[i],c+col[i])){
                count = dfs(grid,r+row[i],c+col[i],vis,count);
            }
        }

        return count;
    }

    public boolean isValid(int[][] grid, boolean[][] vis, int r, int c){
        return r>=0 && c>=0 && r<grid.length && c<grid[0].length && !vis[r][c] && grid[r][c]==1;
    }
}