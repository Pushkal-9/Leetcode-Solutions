// Last updated: 19/04/2025, 01:03:18
class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;

        Pair<Integer,Integer>[] cells = new Pair[n*n+1];

        int index = 1;

        Integer[] columns = new Integer[n];

        for(int i=0;i<columns.length;i++){
            columns[i]=i;
        }

        for(int row = n-1;row>=0;row--){
            for(int column : columns){
                cells[index] = new Pair<>(row,column);
                index++;
            }

            Collections.reverse(Arrays.asList(columns));
        }

        Queue<Integer> q = new LinkedList<>();

        int[] dist = new int[n*n + 1];

        Arrays.fill(dist,-1);

        dist[1]=0;

        q.add(1);

        while(!q.isEmpty()){
            int cur = q.poll();

            for(int next = cur+1; next<= Math.min(cur+6, n*n); next++){
                int row = cells[next].getKey(), col = cells[next].getValue();

                int dest = board[row][col] != -1 ? board[row][col] : next;

                if(dist[dest]==-1){
                    dist[dest]=dist[cur]+1;
                    q.add(dest);
                }
            }
        }

        return dist[n*n];
    }
}