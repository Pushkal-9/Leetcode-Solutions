class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<Point> q = new LinkedList<>();

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2){
                    q.add(new Point(i,j));
                }
            }
        }

        q.add(null);

        int[] r = {0,1,0,-1};
        int[] c = {1,0,-1,0};

        int count = -1;

        while(!q.isEmpty()){
            Point p = q.remove();
            System.out.println(q.size());
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

                    if(row>=0 && col>=0 && row<grid.length && col<grid[0].length && grid[row][col]==1){
                        grid[row][col]=2;

                        q.add(new Point(row,col));
                    }
                }
            }
        }

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    return -1;
                }
            }
        }


        return count;
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