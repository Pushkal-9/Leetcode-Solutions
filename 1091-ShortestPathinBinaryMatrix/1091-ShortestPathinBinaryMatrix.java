// Last updated: 28/06/2025, 13:15:34
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        Queue<Pair> q = new LinkedList<>();

        boolean[][] vis = new boolean[grid.length][grid[0].length];

        if(grid[0][0] == 1){
            return -1;
        }

        q.add(new Pair(0,0,1));
        vis[0][0] = true;

        if(grid.length == 0){
            return 0;
        }

        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                Pair p = q.poll();
                int dist = p.dist;

                if(p.x == grid.length-1 && p.y == grid[0].length-1){
                    return dist;
                }

                int[] r = {0,1,0,-1,1,1,-1,-1};
                int[] c = {1,0,-1,0,1,-1,1,-1};

                for(int k = 0; k < 8; k++){
                    if(isSafe(p.x+r[k], p.y + c[k], grid, vis)){
                        vis[p.x + r[k]][p.y + c[k]] = true;
                        q.add(new Pair(p.x + r[k], p.y + c[k], dist + 1));
                    }
                }
            }

        }

        return -1;
    }

    public boolean isSafe(int r, int c, int[][] grid, boolean[][] vis){
        return r>=0 && c>=0 && r<grid.length && c<grid[0].length && grid[r][c] == 0 && !vis[r][c];
    }
}

class Pair{
    int x;
    int y;
    int dist;

    public Pair(int x, int y, int dist){
        this.x = x;
        this.y = y;
        this.dist = dist;
    }
}