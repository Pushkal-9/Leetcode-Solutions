// Last updated: 19/04/2025, 21:30:59
class Solution {
    public boolean exist(char[][] board, String word) {
        char[] chars = word.toCharArray();

        boolean[][] vis;

        for(int i=0;i<board.length;i++){

            for(int j=0;j<board[0].length;j++){

                vis = new boolean[board.length][board[0].length];

                if(board[i][j]==chars[0]){

                    if(dfs(board, chars, 0, i, j, vis)){

                        return true;
                    }
                }
            }
        }

        return false;
    }

    public boolean dfs(char[][] board, char[] word, int cur, int row, int col, boolean[][] vis){

        if(cur==word.length-1){
            return true;
        }

        vis[row][col] = true;

        int[] r = {0,1,0,-1};

        int[] c = {1,0,-1,0};

        for(int i=0;i<4;i++){

            if(isSafe(board, vis, row+r[i], col+c[i], word[cur+1])){

                vis[row+r[i]][col+c[i]] = true;

                if(dfs(board, word, cur+1, row+r[i], col+c[i], vis)){

                    return true;
                }
                vis[row+r[i]][col+c[i]] = false;
            }
        }

        return false;
    }

    public boolean isSafe(char[][] board, boolean[][] vis, int row, int col, char ch){
        return row>=0 && col>=0 && row<board.length && col<board[0].length && !vis[row][col] && ch==board[row][col];
    }
}