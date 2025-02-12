class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount==0){
            return amount;
        }

        int[] dp = new int[amount+1];

        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;

        for(int i=1;i<dp.length;i++){
            for(int j : coins){
                if(i>=j && dp[i-j]<Integer.MAX_VALUE){
                    dp[i]=Math.min(dp[i],dp[i-j]+1);
                }
            }
        }

        return dp[amount]!=Integer.MAX_VALUE?dp[amount]:-1;
    }
}