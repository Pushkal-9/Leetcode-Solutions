// Last updated: 15/05/2025, 17:43:02
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];

        Arrays.fill(dp,Integer.MAX_VALUE);

        dp[0]=0;

        for(int i=1;i<=amount;i++){
            for(int j : coins){
                if(i>=j && dp[i-j] != Integer.MAX_VALUE){
                    dp[i] = Math.min(dp[i-j]+1,dp[i]);
                }
            }
        }

        return dp[amount]==Integer.MAX_VALUE? -1 : dp[amount];
    }
}