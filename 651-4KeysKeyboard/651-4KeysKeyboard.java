// Last updated: 05/05/2025, 20:28:32
class Solution {
    public int maxA(int n) {
        int[] dp = new int[n+1];


        for(int i=1;i<=n;i++){
            dp[i]=i;

            for(int j=i-3;j>=1;j--){
                dp[i]= Math.max(dp[i],dp[j]* (i-j-1));
            }
        }

        return dp[n];
    }
}