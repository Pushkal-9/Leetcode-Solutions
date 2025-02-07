class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int[][] out = new int[k][2];

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> 
        (int)((Math.pow(a[0],2)+Math.pow(a[1],2)-Math.pow(b[0],2)-Math.pow(b[1],2))));

        for(int[] point : points){
            pq.add(point);
        }

        for(int i=0;i<k;i++){
            out[i] = pq.poll();
        }

        return out;
    }
}