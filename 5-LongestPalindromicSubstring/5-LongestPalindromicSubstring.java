// Last updated: 24/05/2025, 23:33:28
class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];

        for(int i=0;i<n;i++){
            dp[i][i]=1;
        }

        int max = 1;

        String res = s.substring(0,1);

        for(int i=1;i<n;i++){
            for(int j=0;j+i<n;j++){
                if(i==1 && s.charAt(j)==s.charAt(j+i)){
                    dp[j][j+i] = 2;
                }
                else if(s.charAt(j)==s.charAt(j+i) && dp[j+1][j+i-1]!=0){
                    dp[j][j+i] = 2 + dp[j+1][j+i-1];
                }

                if(max<dp[j][j+i]){
                    max = Math.max(max,dp[j][j+i]);
                    res = s.substring(j,j+i+1);
                }
            }
        }

        return res;
    }
}