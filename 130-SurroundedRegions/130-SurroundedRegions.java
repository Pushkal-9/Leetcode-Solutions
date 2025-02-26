class Solution {
    HashSet<Point> set;
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] vis = new boolean[m][n];
        set = new HashSet<>();

        for(int i=0;i<m;i++){
            int j = 0;
            if(!vis[i][j] && board[i][j]=='O'){
                dfs(board,i,j,vis);
            }
        }

        for(int i=0;i<m;i++){
            int j = n-1;
            if(!vis[i][j] && board[i][j]=='O'){
                dfs(board,i,j,vis);
            }
        }

        for(int j=0;j<n;j++){
            int i = 0;
            if(!vis[i][j] && board[i][j]=='O'){
                dfs(board,i,j,vis);
            }
        }

        for(int j=0;j<n;j++){
            int i = m-1;
            if(!vis[i][j] && board[i][j]=='O'){
                dfs(board,i,j,vis);
            }
        }

        for(int i=0;i<m;i++){
            Arrays.fill(board[i],'X');
        }

        for(Point p : set){
            board[p.x][p.y]='O';
        }
    }

    public void dfs(char[][] board, int r, int c, boolean[][] vis){
        vis[r][c]=true;

        set.add(new Point(r,c));

        int[] row ={0,1,0,-1};
        int[] col ={1,0,-1,0};

        for(int i=0;i<4;i++){
            if(isValid(board,r+row[i],c+col[i],vis)){
                dfs(board,r+row[i],c+col[i],vis);
            }
        }
    }

    public boolean isValid(char[][] board, int row, int col, boolean[][] vis){
        return row>=0 && col>=0 && row<board.length && col<board[0].length && !vis[row][col] && board[row][col]=='O';
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