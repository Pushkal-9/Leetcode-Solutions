// Last updated: 15/04/2025, 23:55:50
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int count =0;

        Arrays.sort(intervals,(a,b) -> (a[0]-b[0]));

        int end = intervals[0][1];

        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0]>=end){
                end = intervals[i][1];
            }
            else{
                count++;
                end = Math.min(intervals[i][1],end);
            }
        }

        return count;
    }
}