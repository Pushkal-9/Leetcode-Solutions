class Solution {
    public int numIslands(char[][] grid) {
        boolean[][] vis = new boolean[grid.length][grid[0].length];

        int count = 0;

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1' && !vis[i][j]){
                    count++;
                    dfs(grid,i,j,vis);
                }
            }
        }

        return count;
    }

    public void dfs(char[][] grid, int r, int c, boolean[][] vis){
        vis[r][c]=true;

        int[] row = {0,1,0,-1};
        int[] col = {1,0,-1,0};

        for(int i=0;i<4;i++){
            if(isValid(grid,vis,r+row[i],c+col[i])){
                dfs(grid,r+row[i],c+col[i],vis);
            }
        }
    }

    public boolean isValid(char[][] grid, boolean[][] vis, int r, int c){
        return r>=0 && c>=0 && r<grid.length && c<grid[0].length && !vis[r][c] && grid[r][c]=='1';
    }
}