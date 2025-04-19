// Last updated: 19/04/2025, 15:15:24
class Solution {
    public String longestPalindrome(String s) {
        int[][] dp = new int[s.length()][s.length()];

        for(int i=0;i<s.length();i++){
            dp[i][i]=1;
        }

        int max = 1;

        String longest = s.substring(0,1);


        for(int i=1;i<s.length();i++){
            for(int j=0;j<s.length()-i;j++){
                if(s.charAt(j)==s.charAt(j+i)){
                    if(i==1){
                        dp[j][j+i] = 2;
                    }
                    if(dp[j+1][j+i-1]!=0){
                        dp[j][j+i] = 2 + dp[j+1][j+i-1];
                    }
                }

                if(dp[j][j+i]>max){
                    longest = s.substring(j,j+i+1);
                }
            }
        }

        return longest;
    }
}