// Last updated: 28/06/2025, 17:47:38
class Solution {
    public int countSubstrings(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];

        for(int i=0; i<s.length(); i++){
            dp[i][i] = true;
        }

        int count = s.length();

        for(int i=1;i<s.length();i++){
            for(int j=0;j+i<s.length();j++){
                if(s.charAt(j) == s.charAt(j+i)){
                    if(i==1){
                        dp[j][j+i] = true;
                    }
                    else{
                        dp[j][j+i] = dp[j+1][j+i-1];
                    }
                }

                if(dp[j][j+i]){
                    count++;
                }
            }
        }

        return count;

    }
}