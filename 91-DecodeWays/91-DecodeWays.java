// Last updated: 28/06/2025, 17:21:12
class Solution {
    public int numDecodings(String s) {
        int[] dp = new int[s.length()+1];

        dp[0] = 1;

        if(s.charAt(0) == '0'){
            return 0;
        }

        dp[1] = 1;

        for(int i=1;i<s.length();i++){
            char ch = s.charAt(i);
            char prev = s.charAt(i-1);

            if('1' <= ch && ch <= '9'){
                dp[i+1] += dp[i];
            }

            if(prev == '1'){
                dp[i+1] += dp[i-1];
            }
            else if(prev == '2' && (ch >= '0' && ch <= '6')){
                dp[i+1] += dp[i-1];
            }

            if(dp[i] == 0){
                return 0;
            }
        }

        return dp[s.length()];
    }
}