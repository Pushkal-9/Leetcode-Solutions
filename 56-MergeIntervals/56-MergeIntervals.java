// Last updated: 25/06/2025, 22:05:31
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0]-b[0]);

        int start = intervals[0][0];
        int end = intervals[0][1];

        List<int[]> list = new ArrayList<>();

        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0]<=end){
                end = Math.max(end, intervals[i][1]);
            }
            else{
                int[] interval = {start,end};
                list.add(interval);
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }

        int[] interval = {start,end};
        list.add(interval);

        int[][] res = new int[list.size()][2];

        for(int i=0;i<list.size();i++){
            res[i] = list.get(i);
        }

        return res;
    }
}