// Last updated: 19/04/2025, 15:49:15
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];

        Arrays.fill(dp,Integer.MAX_VALUE);

        dp[0]=0;

        for(int i=1;i<dp.length;i++){
            for(int coin : coins){
                if(i>=coin && dp[i-coin] != Integer.MAX_VALUE){
                    dp[i]= Math.min(1+dp[i-coin],dp[i]);
                }
            }
        }

        return dp[amount]==Integer.MAX_VALUE ? -1 : dp[amount];
    }
}