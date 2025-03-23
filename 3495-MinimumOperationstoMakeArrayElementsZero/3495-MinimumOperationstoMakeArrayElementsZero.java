// Last updated: 23/03/2025, 01:38:56
class Solution {
    public long minOperations(int[][] queries) {

        long count = 0;

        for(int i=0;i<queries.length;i++){

            count = count + (sumCountDivisions(queries[i][0],queries[i][1])+1)/2;
        }

        return count;
    }

    private long sumCountDivisions(int a, int b) {
        long sum = 0;
        long lower = 1;
        long upper = 3;
        int d = 1;
        while (lower <= b) {
            long currentLow = Math.max(a, lower);
            long currentHigh = Math.min(b, upper);
            if (currentLow <= currentHigh) {
                sum += (currentHigh - currentLow + 1) * d;
            }
            lower = upper + 1;
            upper = lower * 4 - 1;
            d++;
        }
        return sum;
    }
}