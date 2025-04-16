// Last updated: 16/04/2025, 00:49:38
class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        Interval[] intervals = new Interval[n];

        for (int i = 0; i < n; i++) {
            intervals[i] = new Interval(startTime[i], endTime[i], profit[i]);
        }

        Arrays.sort(intervals, (a, b) -> a.end - b.end);


        int[] dp = new int[n];
        dp[0] = intervals[0].profit;

        for (int i = 1; i < n; i++) {
            int currProfit = intervals[i].profit;


            int lastIndex = findLastNonConflictingJob(intervals, i);
            if (lastIndex != -1) {
                currProfit += dp[lastIndex];
            }

            dp[i] = Math.max(dp[i - 1], currProfit);
        }

        return dp[n - 1];
    }

    private int findLastNonConflictingJob(Interval[] intervals, int index) {
        int low = 0, high = index - 1;
        int result = -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (intervals[mid].end <= intervals[index].start) {
                result = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return result;
    }
}

class Interval {
    int start;
    int end;
    int profit;

    public Interval(int start, int end, int profit) {
        this.start = start;
        this.end = end;
        this.profit = profit;
    }
}
