class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];

        int max = 0;

        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                max = Math.max(max,helper(matrix,i,j,dp));
            }
        }

        return max+1;
    }

    public int helper(int[][] matrix, int i, int j, int[][] dp){
        if(dp[i][j]!=0){
            return dp[i][j];
        }
        if(i>=matrix.length || j>=matrix[0].length || i<0 || j<0){
            return 0;
        }

        int max = 0;

        int[] row = {0,1,0,-1};
        int[] col = {1,0,-1,0};

        for(int k=0;k<4;k++){
            if(isValid(matrix,i+row[k],j+col[k]) && matrix[i][j]<matrix[i+row[k]][j+col[k]]){
                max = Math.max(max,1+helper(matrix,i+row[k],j+col[k],dp));
            }
        }

        dp[i][j]= max;

        return max;
    }

    public boolean isValid(int[][] matrix, int i, int j){
        return i<matrix.length && j<matrix[0].length && i>=0 && j>=0;
    }


}