// Last updated: 15/05/2025, 17:49:31
class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount+1];

        dp[0]=1;


        for(int coin : coins){
            for(int i=1;i<=amount;i++){
                if(i>=coin && dp[i-coin]!=0){
                    dp[i]=dp[i-coin]+dp[i];
                }
            }
        }

        return dp[amount];
    }
}