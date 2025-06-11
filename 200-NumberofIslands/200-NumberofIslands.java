// Last updated: 11/06/2025, 15:22:21
class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        boolean[][] vis = new boolean[grid.length][grid[0].length];

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

    public void dfs(char[][] grid, int row, int col, boolean[][] vis){
        if(row>=grid.length || col>=grid[0].length || vis[row][col]){
            return;
        }

        vis[row][col] = true;

        int[] r = {0,0,1,-1};
        int[] c = {1,-1,0,0};

        for(int i=0;i<4;i++){
            int nr = row + r[i];
            int nc = col + c[i];

            if(isSafe(grid,nr,nc,vis)){
                dfs(grid,nr,nc,vis);
            }
        }
    }

    private boolean isSafe(char[][] grid, int row, int col, boolean[][] vis){
        return row>=0 && col>= 0 && row<grid.length && col<grid[0].length && !vis[row][col]
         && grid[row][col]=='1';
    }
}