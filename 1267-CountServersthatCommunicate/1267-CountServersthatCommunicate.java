// Last updated: 28/03/2025, 22:10:27
class Solution {
    public int countServers(int[][] grid) {
        boolean[][] vis = new boolean[grid.length][grid[0].length];

        int count = 0;

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(!vis[i][j] && grid[i][j]==1){
                    int nodes = dfs(grid,i,j,vis);

                    if(nodes!=1){
                        count=count + nodes;
                    }
                }
            }
        }

        return count;
    }

    public int dfs(int[][] grid, int row, int col, boolean[][] vis){
        
        vis[row][col]=true;

        int count = 1;

        int[] r = {0,1,0,-1};
        int[] c = {1,0,-1,0};



        for(int i=0;i<grid[0].length;i++){
            if(isValid(grid,row,i,vis)){
                count = count + dfs(grid,row,i,vis);
            }
        }

        for(int i=0;i<grid.length;i++){
            if(isValid(grid,i,col,vis)){
                count = count + dfs(grid,i,col,vis);
            }
        }

        return count;
    }

    public boolean isValid(int[][] grid, int row, int col, boolean[][] vis){
        return grid[row][col]==1 && !vis[row][col];
    }
}