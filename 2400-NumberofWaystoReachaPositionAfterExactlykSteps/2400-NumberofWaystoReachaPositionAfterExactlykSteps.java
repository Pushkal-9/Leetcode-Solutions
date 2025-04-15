// Last updated: 15/04/2025, 15:49:56
class Solution {
    Long[][] dp;
    int offset = 1000;
    int MOD = 1_000_000_007;

    public int numberOfWays(int startPos, int endPos, int k) {
        dp = new Long[3001][k + 1];
        return (int)(helper(startPos, endPos, k, 0) % MOD); 
    }

    public long helper(int current, int end, int k, int step) {
        if (step > k) return 0;
        if (dp[offset + current][step] != null) return dp[offset + current][step];
        if (current == end && step == k) return 1;

        long ways = helper(current + 1, end, k, step + 1)
                  + helper(current - 1, end, k, step + 1);

        dp[offset + current][step] = ways % MOD;
        return dp[offset + current][step];
    }
}
