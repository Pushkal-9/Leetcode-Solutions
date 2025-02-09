class Solution {
    public boolean exist(char[][] board, String word) {
        boolean[][] vis;

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                vis = new boolean[board.length][board[0].length];
                if(board[i][j]==word.charAt(0) && exist(board,word,String.valueOf(board[i][j]),i,j,vis)){
                    return true;
                }
            }
        }

        return false;
    }

    public boolean exist(char[][] board, String word, String current, int row, int col, boolean[][] vis){
        if(row<0 || col<0 || row>=board.length || col>=board[0].length){
            return false;
        }

        if(word.equals(current)){
            return true;
        }

        //System.out.println(current);

        int[] r = {0,0,1,-1};
        int[] c = {1,-1,0,0};

        boolean res = false;

        for(int i=0;i<4;i++){
            char ch = word.charAt(current.length());
            if(isValid(board,word,row+r[i],col+c[i],ch,vis)){
                vis[row][col]=true;
                String base = current + String.valueOf(ch);
                //System.out.println(ch);
                if(exist(board,word,base,row+r[i],col+c[i],vis)){
                    return true;
                }
                vis[row][col]=false;
            }
        }

        return false;
    }

    public boolean isValid(char[][] board, String word, int row, int col, char ch, boolean[][] vis){
        return row>=0 && col>=0 && row<board.length && col<board[0].length && !vis[row][col] && ch==board[row][col];
    }
}