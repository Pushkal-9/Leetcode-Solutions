// Last updated: 05/05/2025, 20:30:16
class Solution {
    public int maxA(int N) {
        int[] dp = new int[N+1];
        for (int i=1; i<=N; i++) {
            if (i<=5) {
                dp[i] = i;
            } else {
                dp[i] = Math.max(dp[i-1]+1, Math.max(dp[i-3]*2, Math.max(dp[i-4]*3, dp[i-5]*4)));
            }
        }
        return dp[N];
    }
}