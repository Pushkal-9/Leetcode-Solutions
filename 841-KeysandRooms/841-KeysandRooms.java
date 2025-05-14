// Last updated: 14/05/2025, 13:57:37
class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(0);

        boolean[] vis = new boolean[rooms.size()];

        vis[0]=true;

        while(!queue.isEmpty()){
            int size = queue.size();

            for(int i=0;i<size;i++){
                int room = queue.poll();

                for(int j=0;j<rooms.get(room).size();j++){
                    int cur = rooms.get(room).get(j);
                    if(!vis[cur]){
                        queue.add(cur);
                        vis[cur]=true;
                    }
                }
            }
        }

        for(int i=0;i<rooms.size();i++){
            if(!vis[i]){
                return false;
            }
        }

        return true;
    }
}