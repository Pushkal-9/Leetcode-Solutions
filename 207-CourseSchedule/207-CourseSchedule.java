// Last updated: 14/05/2025, 15:51:56
class Solution {
    HashMap<Integer, List<Integer>> adj;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        buildAdj(numCourses, prerequisites);

        int[] indegrees = new int[numCourses];

        for(int i=0;i<prerequisites.length;i++){
            indegrees[prerequisites[i][0]]++;
        }

        Queue<Integer> q = new LinkedList<>();

        boolean[] vis = new boolean[numCourses];

        int[] res = new int[numCourses];

        int index = 0;

        for(int i=0;i<indegrees.length;i++){
            if(indegrees[i]==0){
                q.add(i);
                vis[i]=true;
                res[index]=i;
                index++;
            }
        }

        while(!q.isEmpty()){
            int node = q.poll();

            for(int cur : adj.get(node)){
                if(!vis[cur]){
                    indegrees[cur]--;
                    
                    if(indegrees[cur]==0){
                        q.add(cur);
                        vis[cur]=true;
                        res[index]=cur;
                        index++;
                    }
                }
            }
        }

        for(boolean node : vis){
            if(!node){
                return new int[0];
            }
        }

        return res;
    }

    public void buildAdj(int n, int[][] pre){

        adj = new HashMap<>();

        for(int i=0;i<n;i++){
            adj.put(i, new ArrayList<>());
        }

        for(int[] pair : pre){
            adj.get(pair[1]).add(pair[0]);
        }
    }

}