// Last updated: 15/05/2025, 18:17:51
class Solution {
    public int countSubstrings(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];

        int count = s.length();

        for(int i=0;i<s.length();i++){
            dp[i][i]=true;
        }

        for(int i=1;i<s.length();i++){
            for(int j=0;j<s.length()-i;j++){
                if(s.charAt(j)==s.charAt(j+i)){
                if(i==1){
                    dp[j][j+i]=true;
                }
                else if (dp[j+1][j+i-1]){
                    dp[j][j+i]=true;
                }

                if(dp[j][j+i]){
                    count++;
                }
                }
            }
        }

        return count;
    }
}