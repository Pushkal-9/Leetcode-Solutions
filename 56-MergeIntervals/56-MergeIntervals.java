// Last updated: 15/05/2025, 23:22:08
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0]-b[0]);

        int start = intervals[0][0], end = intervals[0][1];

        List<int[]> list = new ArrayList<>();

        for(int i=0;i<intervals.length;i++){
            if(end>=intervals[i][0]){
                end = Math.max(end, intervals[i][1]);
            }
            else{
                int[] in = {start,end};
                list.add(in);
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }

        int[] in = {start,end};
        list.add(in);

        int[][] result = new int[list.size()][2];

        for(int i=0;i<list.size();i++){
            result[i] = list.get(i);
        }

        return result;
    }
}