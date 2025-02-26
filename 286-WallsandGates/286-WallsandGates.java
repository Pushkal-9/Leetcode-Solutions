class Solution {
    public void wallsAndGates(int[][] grid) {
        Queue<Point> q = new LinkedList<>();

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==0){
                    q.add(new Point(i,j));
                }
            }
        }

        q.add(null);

        int[] r = {0,1,0,-1};
        int[] c = {1,0,-1,0};

        int count = 1;

        while(!q.isEmpty()){
            Point p = q.remove();
            if(p==null){
                count++;
                if(q.isEmpty()){
                    break;
                }
                q.add(null);
            }
            else{
                for(int i=0;i<4;i++){
                    int row = p.x + r[i];
                    int col = p.y + c[i];

                    if(row>=0 && col>=0 && row<grid.length && col<grid[0].length && grid[row][col]==2147483647){
                        grid[row][col] = count;
                        q.add(new Point(row,col));
                    }
                }
            }
        }

    }
}

class Point{
    int x;
    int y;
    public Point(int x, int y){
        this.x=x;
        this.y=y;
    }
}