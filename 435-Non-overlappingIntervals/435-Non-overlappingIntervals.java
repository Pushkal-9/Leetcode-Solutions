// Last updated: 15/04/2025, 23:56:32
import java.util.*;

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int end = intervals[0][1];

        int count=0;

        for(int i=1;i<intervals.length;i++){
            if(end<=intervals[i][0]){
                end = intervals[i][1];
            }
            else{
                count++;
                end = Math.min(end,intervals[i][1]);
            }
        }

        return count;
    }
}