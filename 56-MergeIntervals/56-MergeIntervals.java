// Last updated: 19/04/2025, 13:55:48
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0]-b[0]);

        List<int[]> result = new ArrayList<>();

        int end = intervals[0][1];
        int start = intervals[0][0];

        for(int i=1;i<intervals.length;i++){
            if(end>=intervals[i][0]){
                end = Math.max(end,intervals[i][1]);
            }
            else{
                int[] in = {start,end};

                result.add(in);

                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        
        int[] in = {start,end};

        result.add(in);

        int[][] res = new int[result.size()][2];

        for(int i=0;i<res.length;i++){
            res[i]=result.get(i);
        }

        return res;

    }
}