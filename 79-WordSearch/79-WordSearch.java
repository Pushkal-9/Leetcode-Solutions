// Last updated: 16/05/2025, 00:25:38
class Solution {
    boolean[][] vis ;
    public boolean exist(char[][] board, String word) {
        
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                vis = new boolean[board.length][board[0].length];
                if(board[i][j]==word.charAt(0)){
                    if(exist(board,word,i,j,"")){
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public boolean exist(char[][] board, String word, int row, int col, String current){
        if(current.equals(word)){
            return true;
        }

        int[] r = {0,1,0,-1};
        int[] c = {1,0,-1,0};

        boolean res = false;

        if(isSafe(board,row,col,current,word)){
            vis[row][col]=true;
            for(int i=0;i<4;i++){
                String newCurrent = current + String.valueOf(board[row][col]);
                if(exist(board,word,row+r[i],col+c[i],newCurrent)){
                    return true;
                }
            }
            vis[row][col]=false;
        }

        return false;
    }

    public boolean isSafe(char[][] board, int row, int col, String current, String word){
        return row>=0 && col>=0 && row<board.length && col<board[0].length && word.length()>current.length() &&
                board[row][col]==word.charAt(current.length()) && !vis[row][col];
    }
}