// Last updated: 15/04/2025, 19:06:24
class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();

        int[][] dp = new int[n][n];


        for(int i=0;i<n;i++){
            dp[i][i]=1;
        }

        int max = 1;

        String result= s.substring(0,1);


        for(int i=1;i<n;i++){
            for(int j=0;j<n-i;j++){
                if(s.charAt(j)==s.charAt(j+i)){
                    if(dp[j+1][j+i-1]!=0 || i==1){
                        dp[j][j+i]=2+dp[j+1][j+i-1];
                        result = s.substring(j,j+i+1);
                    }
                }
            }
        }

        return result;
    }
}