// Last updated: 24/05/2025, 23:22:27
class Solution {
    public boolean exist(char[][] board, String word) {
        boolean[][] vis;

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                vis = new boolean[board.length][board[0].length];
                if(board[i][j]==word.charAt(0)){
                    if(exist(board,word,vis,i,j,0)){
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public boolean exist(char[][] board, String word, 
                                                boolean[][] vis, int row, int col, int index){
        if(index>=word.length()){
            return true;
        }

        int[] r = {0,0,-1,1};
        int[] c = {1,-1,0,0};

        if(isSafe(board,word,row,col,vis,index)){
            vis[row][col] = true;
            for(int i=0;i<4;i++){
                if(exist(board,word,vis,row+r[i],col+c[i],index+1)){
                    return true;
                }
            }
            vis[row][col] = false;
        }

        return false;
    }

    public boolean isSafe(char[][] board, String word, int row, int col, boolean[][] vis, int index){
        return row>=0 && col>=0 && row<board.length && col<board[0].length && !vis[row][col] && board[row][col]==word.charAt(index);
    }
}