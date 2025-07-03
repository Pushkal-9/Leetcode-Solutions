// Last updated: 02/07/2025, 20:15:29
class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean [][] dp = new boolean[n][n];

        for(int i=0;i<n;i++){
            dp[i][i] = true;
        }

        int max = 1;

        String result = s.substring(0,1);

        for(int i=1;i<n;i++){
            for(int j=0;j+i<n;j++){
                if(s.charAt(j) == s.charAt(i+j)){
                    if(i==1 || dp[j+1][j+i-1]){
                        dp[j][i+j] = true;
                        if(max < i+1){
                            max = i+1;
                            result = s.substring(j,i+j+1);
                        }
                    }
                }
            }
        }

        return result;
    }
}