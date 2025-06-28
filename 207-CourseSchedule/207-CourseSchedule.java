// Last updated: 28/06/2025, 13:57:27
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = buildAdj(prerequisites, numCourses);

        int[] indegrees = new int[numCourses];

        for(int i=0;i<prerequisites.length;i++){
            indegrees[prerequisites[i][0]]++;
        }

        Queue<Integer> q = new LinkedList<>();

        int taken = 0;

        for(int i=0;i<indegrees.length;i++){
            if(indegrees[i]==0){
                q.add(i);
                taken++;
            }
        }

        while(!q.isEmpty()){
            int size = q.size();

            for(int i = 0;i<size;i++){
                int node = q.poll();
                for(int next : map.get(node)){
                    indegrees[next]--;

                    if(indegrees[next]==0){
                        q.add(next);
                        taken++;
                    }
                }
            }
        }

        if(taken!=numCourses){
            return false;
        }

        return true;
    }

    public Map<Integer,List<Integer>> buildAdj(int[][] pre, int num){
        Map<Integer, List<Integer>> map = new HashMap<>();

        for(int i=0;i<num;i++){
            map.put(i, new ArrayList<>());
        }

        for(int[] p : pre){
            map.get(p[1]).add(p[0]);
        }

        return map;
    }
}