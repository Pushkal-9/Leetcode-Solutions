class Solution {
    HashMap<Integer, ArrayList<Integer>> adj = new HashMap<>();
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        
        for(int i=0;i<prerequisites.length;i++){
            int[] pre = prerequisites[i];
            int node = pre[0];
            int neighbor = pre[1];

            adj.putIfAbsent(pre[0],new ArrayList<Integer>());
            adj.get(pre[0]).add(pre[1]);
        }

        int[] indegrees = new int[numCourses];

        for(int i=0;i<numCourses;i++){
            if(adj.containsKey(i)){
                for(int to : adj.get(i)){
                    indegrees[to]++;
                }
            }
        }

        boolean[][] pre = new boolean[numCourses][numCourses];

        Queue<Integer> q = new LinkedList<>();

        for(int i=0;i<numCourses;i++){
            if(indegrees[i]==0){
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            int node = q.poll();
            if(!adj.containsKey(node)){
                continue;
            }
            for(int to : adj.get(node)){
                indegrees[to]--;
                pre[node][to]=true;

                for(int i=0;i<numCourses;i++){
                    if(pre[i][node]){
                        pre[i][to]=true;
                    }
                }

                if(indegrees[to]==0){
                    q.add(to);
                }
            }
        }

        List<Boolean> res = new ArrayList<>();

        for(int[] query : queries){
            int node = query[0];
            int neighbor = query[1];
            res.add(pre[node][neighbor]);
        }

        return res;

    }
}