// Last updated: 09/07/2025, 15:34:00
class Solution {
    public int getFood(char[][] grid) {
        Queue<Point> q = new LinkedList<>();

        boolean[][] vis = new boolean[grid.length][grid[0].length];

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == '*'){
                    q.add(new Point(i,j,0));
                    vis[i][j] = true;
                    break;
                }
            }
        }

        int[] r = {0,0,-1,1};
        int[] c = {-1,1,0,0};

        while(!q.isEmpty()){
            int size = q.size();

            for(int i=0;i<size;i++){
                Point p = q.poll();

                for(int k=0;k<4;k++){
                    int row = p.x + r[k];
                    int col = p.y + c[k];
                    if(isSafe(row,col,grid,vis)){
                        if(grid[row][col] == '#'){
                            return p.dist+1;
                        }

                        q.add(new Point(row,col,p.dist+1));
                        vis[row][col] = true;
                    }
                }
            }
        }

        return -1;
    }

    public boolean isSafe(int x, int y, char[][] grid, boolean[][] vis){
        return x>=0 && y>=0 && x<grid.length && y<grid[0].length && !vis[x][y] && grid[x][y]!='X';
    }
}

class Point{
    int x;
    int y;
    int dist;

    public Point(int x, int y, int dist){
        this.x=x;
        this.y=y;
        this.dist = dist;
    }
}