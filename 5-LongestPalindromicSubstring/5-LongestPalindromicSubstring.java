// Last updated: 15/05/2025, 20:09:22
class Solution {
    public String longestPalindrome(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];

        for(int i=0;i<dp.length;i++){
            dp[i][i] = true;
        }

        String max =  s.substring(0,1);

        for(int i=1;i<s.length();i++){
            for(int j=0;i+j<s.length();j++){
                if(s.charAt(j)==s.charAt(i+j)){
                    if(i==1 || dp[j+1][i+j-1]){
                        dp[j][i+j]=true;
                    }
                }

                if(dp[j][i+j]){
                    max = s.substring(j,i+j+1);
                }
            }
        }

        return max;
    }
}