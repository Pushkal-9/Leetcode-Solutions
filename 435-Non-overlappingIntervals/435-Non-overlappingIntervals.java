// Last updated: 15/04/2025, 23:51:49
import java.util.*;

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);

        int[] dp = new int[n];
        dp[0] = 1;

        for (int i = 1; i < n; i++) {

            int prev = binarySearch(intervals, i);
            if (prev != -1) {
                dp[i] = Math.max(dp[i - 1], dp[prev] + 1);
            } else {
                dp[i] = Math.max(dp[i - 1], 1);
            }
        }

        int maxNonOverlapping = dp[n - 1];
        return n - maxNonOverlapping;
    }

    private int binarySearch(int[][] intervals, int curr) {
        int low = 0, high = curr - 1;
        int target = intervals[curr][0];
        int res = -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (intervals[mid][1] <= target) {
                res = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return res;
    }
}