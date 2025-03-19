class Solution {
    HashMap<Integer, ArrayList<Integer>> adj = new HashMap<>();
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        boolean[] vis = new boolean[numCourses];

        for(int[] pre : prerequisites){
            int node = pre[0];
            int neighbor = pre[1];

            adj.putIfAbsent(node,new ArrayList<>());
            adj.get(node).add(neighbor);
        }

        int[] indegrees = new int[numCourses];

        for(int i=0;i<numCourses;i++){
            if(adj.containsKey(i)){
                for(int to : adj.get(i)){
                    indegrees[to]++;
                }
            }
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i=0;i<numCourses;i++){
            if(indegrees[i]==0){
                q.add(i);
            }
        }

        int[] res = new int[numCourses];

        int index=0;

        while(!q.isEmpty()){
            int node = q.poll();
            res[index]=node;
            index++;

            if(!adj.containsKey(node)){
                continue;
            }
            for(int in : adj.get(node)){
                indegrees[in]--;

                if(indegrees[in]==0){
                    q.add(in);
                }
            }
        }

        if(index!=numCourses){
            return false;
        }

        return true;

    }
}