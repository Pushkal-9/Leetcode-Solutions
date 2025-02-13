class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount+1];

        dp[0]=1;

        for(int coin : coins){
            for(int i=1;i<=amount;i++){
                int current = i;
                if(current-coin>=0 && dp[current-coin]!=0){
                    dp[i]=dp[i]+dp[current-coin];
                }
            }
        }

        return dp[amount];
    }
}