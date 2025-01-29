class Solution {
    public boolean isValidSudoku(char[][] board) {
        return validateRows(board) && validateCols(board) && validateBoxes(board);
    }

    public boolean validateBoxes(char[][] board){
        for(int i=0;i<9;i=i+3){
            for(int j=0;j<9;j=j+3){
                HashSet<Character> set = new HashSet<>();
                int k=0,l=0;
                while(k<3){
                    l=0;
                    while(l<3){
                        if(board[i+k][j+l]!='.'){
                        if(set.contains(board[i+k][j+l])){

                            System.out.println("returning 1");
                            return false;
                        }
                        set.add(board[i+k][j+l]);
                        }
                        l++;          
                    }
                    k++;
                }
            }
        }

        return true;
    }

    public boolean validateRows(char[][] board) {

        for(int i=0;i<9;i++){
            HashSet<Character> set = new HashSet<>();

            for(int j=0;j<9;j++){
                if(board[i][j]!='.'){
                    if(set.contains(board[i][j])){
                        System.out.println("returning 2");
                        return false;
                    }
                    set.add(board[i][j]);
                }
            }
        }

        return true;
    }

    public boolean validateCols(char[][] board) {

        for(int i=0;i<9;i++){
            HashSet<Character> set = new HashSet<>();

            for(int j=0;j<9;j++){
                if(board[j][i]!='.'){
                    if(set.contains(board[j][i])){
                        System.out.println("returning 3");
                        return false;
                    }
                    set.add(board[j][i]);
                }
            }
        }

        return true;
    }
}