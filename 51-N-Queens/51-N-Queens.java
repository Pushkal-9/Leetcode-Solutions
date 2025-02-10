class Solution {
    List<List<String>> res;
    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>();
        char[][] board = new char[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(board[i],'.');
        }
        solve(board,0,n);
        return res;
    }

    public void solve(char[][] board, int index, int n){
        if(index>=n){
            res.add(converter(board));
            return;
        }


        for(int i=0;i<n;i++){
            if(isValid(board,n,index,i)){
                board[i][index]='Q';
                solve(board,index+1,n);
                board[i][index]='.';
            }
        }
    }

    public List<String> converter(char[][] board){
        List<String> boardList = new ArrayList<>();
        for(char[] ch : board){
            String str = new String(ch);
            boardList.add(str);
        }

        return boardList;
    }

    public boolean isValid(char[][] board, int n, int index, int row){
        
        for(int i=0;i<index;i++){
            if(board[row][i]=='Q'){
                return false;
            }
        }

        for(int i=row-1,j=index-1;i>=0 && j>=0;i--,j--){
            if(board[i][j]=='Q'){
                return false;
            }
        }

        for(int i=row+1,j=index-1;i<n && j>=0;i++,j--){
            if(board[i][j]=='Q'){
                return false;
            }
        }

        return true;
    }
}