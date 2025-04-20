// Last updated: 19/04/2025, 21:09:04
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        HashMap<Integer,List<Integer>> adj = constructAdj(numCourses, prerequisites);

        int[] indegrees = new int[numCourses];
        boolean[] vis = new boolean[numCourses];

        for(int[] edge : prerequisites){
            indegrees[edge[0]]++;
        }

        Queue<Integer> q = new LinkedList<>();

        List<Integer> res = new ArrayList<>();

        for(int i=0;i<numCourses;i++){
            if(indegrees[i]==0){
                q.add(i);
                vis[i]=true;
            }
        }

        while(!q.isEmpty()){
            int node = q.poll();
            res.add(node);

            for(int neighbor : adj.get(node)){
                if(!vis[neighbor]){
                    indegrees[neighbor]--;

                    if(indegrees[neighbor]==0){
                        vis[neighbor]=true;
                        q.add(neighbor);
                    }
                }
            }
        }

        if(res.size()!=numCourses){
            return new int[0];
        }

        int[] arr = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            arr[i] = res.get(i);
        }

        return arr;
    }

    public HashMap<Integer,List<Integer>> constructAdj(int n, int[][] edges){
        HashMap<Integer,List<Integer>> adj = new HashMap<>();

        for(int i=0;i<n;i++){
            adj.put(i, new ArrayList<>());
        }

        for(int[] edge : edges){
            int src = edge[1];
            int dest = edge[0];

            adj.get(src).add(dest);
        }

        return adj;
    }

}