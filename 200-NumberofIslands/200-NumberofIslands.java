// Last updated: 19/04/2025, 14:13:16
class Solution {
    public int numIslands(char[][] grid) {
        
        boolean[][] vis = new boolean[grid.length][grid[0].length];

        int count = 0;

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(!vis[i][j] && grid[i][j]=='1'){
                    count++;
                    dfs(grid,vis,i,j);
                }
            }
        }

        return count;
    }

    public void dfs(char[][] grid, boolean[][] vis, int row, int col){

        vis[row][col] = true;

        int[] r = {0,1,0,-1};
        int[] c = {1,0,-1,0};

        for(int i=0; i<4; i++){
            if(isValid(grid,vis,row+r[i],col+c[i])){
                dfs(grid,vis,row+r[i],col+c[i]);
            }
        }
    }

    public boolean isValid(char[][] grid, boolean[][] vis, int row, int col){
        return row>=0 && row<grid.length && col>=0 && col<grid[0].length && !vis[row][col] && grid[row][col]=='1';
    }
}