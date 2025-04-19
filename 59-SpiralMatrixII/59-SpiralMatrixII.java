// Last updated: 18/04/2025, 21:44:02
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];

        int rowStart = 0;
        int colStart = 0;

        int rowEnd = n-1;
        int colEnd = n-1;

        int current = 1;

        while(rowStart <=rowEnd && colStart <=colEnd){

            for(int i=colStart;i<=colEnd;i++){
                matrix[rowStart][i] = current;
                current++;
            }

            rowStart++;

            for(int i=rowStart;i<=rowEnd;i++){
                matrix[i][colEnd] = current;
                current++;
            }

            colEnd--;

            for(int i=colEnd;i>=colStart;i--){
                matrix[rowEnd][i] = current;
                current++;
            }

            rowEnd--;

            for(int i=rowEnd;i>=rowStart;i--){
                matrix[i][colStart] = current;
                current++;
            }

            colStart++;
        }

        return matrix;
    }
}