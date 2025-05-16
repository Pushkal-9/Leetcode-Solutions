// Last updated: 15/05/2025, 23:08:57
class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a,b) -> {
            if(a[1]==b[1]){
                return 0;
            }

            if(a[1]>b[1]){
                return 1;
            }
            return -1;
        });

        int start = points[0][0], end = points[0][1];

        int count = 1;

        for(int i=0;i<points.length;i++){
            if(end>=points[i][0]){
                continue;
            }
            else{
                count++;
                end = points[i][1];
            }
        }

        return count;
    }
}