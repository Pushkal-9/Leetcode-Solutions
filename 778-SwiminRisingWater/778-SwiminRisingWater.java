// Last updated: 13/06/2025, 11:17:15
class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        PriorityQueue<Block> pq = new PriorityQueue<>((a,b) -> (a.value - b.value));
        boolean[][] vis = new boolean[n][n];

        int max = 0;

        pq.add(new Block(0,0, grid[0][0]));

        for(int t = 0; t < n*n; t++ ){

            while(!pq.isEmpty() && t>= pq.peek().value){
                Block block = pq.poll();
                vis[block.x][block.y] = true;

                int[] r = {0,0,-1,1};
                int[] c = {1,-1,0,0};

                for(int i=0;i<4;i++){
                    int row = r[i] + block.x;
                    int col = c[i] + block.y;

                    if(row>=0 && col>=0 && row<n && col<n && !vis[row][col]){
                        pq.add(new Block(row,col,grid[row][col]));
                    }
                }
            }

            if(vis[n-1][n-1]){
                return t;
            }
        }

        return n*n -1;
    }
}

class Block{

    int x;
    int y;
    int value;

    public Block( int x, int y, int value){
        this.x = x;
        this.y = y;
        this.value = value;
    }
}