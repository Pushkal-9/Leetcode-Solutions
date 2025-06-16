// Last updated: 16/06/2025, 16:29:07
class Solution {
    public int numDecodings(String s) {
        int[] dp = new int[s.length()+1];

        if(s.charAt(0)=='0'){
            return 0;
        }

        dp[0]=1;

        dp[1]=1;


        for(int i=1;i<s.length();i++){
            char cur = s.charAt(i);
            char prev = s.charAt(i-1);

            if('1' <= cur && cur <='9'){
                dp[i+1] += dp[i];
            }

            boolean first = ('1' == prev) && ('0' <= cur && cur <='9');
            boolean second = ('2' == prev) && ('0' <= cur && cur <='6');
            
            if(first || second){
                dp[i+1] += dp[i-1];
            }

            if(dp[i+1] == 0){
                return 0;
            }
        }

        return dp[s.length()];
    }
}