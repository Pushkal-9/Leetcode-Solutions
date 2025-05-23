// Last updated: 23/05/2025, 01:48:44
class Solution {
    public double knightProbability(int n, int k, int row, int column) {
        double total = Math.pow(8,k);

        double[][] dp = new double[n][n];

        dp[row][column] = 1;

        int[] r = {1,2,-1,2,1,-2,-1,-2};
        int[] c = {2,1,2,-1,-2,-1,-2,1};

        for(int move=1; move<=k; move++){
            double[][] temp = new double[n][n];

            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(dp[i][j]!=0){
                        for(int l=0;l<8;l++){
                            if(isSafe(i+r[l],j+c[l],n)){
                                temp[i+r[l]][j+c[l]] += dp[i][j];
                            }
                        }
                    }
                }
            }

            dp = temp;
        }

        double count = 0;

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                count += dp[i][j];
            }
        }

        return count/total;
    }

    public boolean isSafe(int row, int col, int n){
        return row>=0 && col>=0 && row<n && col<n;
    }
}