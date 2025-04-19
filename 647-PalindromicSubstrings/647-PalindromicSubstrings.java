// Last updated: 19/04/2025, 15:24:17
class Solution {
    public int countSubstrings(String s) {
        int[][] dp = new int[s.length()][s.length()];

        int count = s.length();

        for(int i=0;i<s.length();i++){
            dp[i][i]=1;
        }

        for(int i=1;i<s.length();i++){
            for(int j=0;j<s.length()-i;j++){
                if(s.charAt(j)==s.charAt(j+i)){
                if(i==1){
                    dp[j][j+i]=2;
                }
                else if (dp[j+1][j+i-1]!=0){
                    dp[j][j+i]=2 + dp[j+1][j+i-1];
                }

                if(dp[j][j+i]!=0){
                    count++;
                }
                }
            }
        }

        return count;
    }
}