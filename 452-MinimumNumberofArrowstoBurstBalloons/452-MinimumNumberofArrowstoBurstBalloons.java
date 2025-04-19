// Last updated: 19/04/2025, 16:17:07
class Solution {
    public int findMinArrowShots(int[][] points) {

        Arrays.sort(points, (a,b)-> {
            if(a[1] == b[1]){
                return 0;
            }

            if(a[1]>b[1]){
                return 1;
            }

            return -1;
        });

        int start = points[0][0], end = points[0][1];

        int count = 1;

        for(int i=1;i<points.length;i++){
            if(points[i][0]<=end){
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