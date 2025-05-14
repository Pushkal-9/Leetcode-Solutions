// Last updated: 14/05/2025, 14:16:19
class Solution {
    HashMap<Integer, List<Integer>> adj;
    List<List<Integer>> res;
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        buildAdj(graph);
        List<Integer> currentList = new ArrayList<>();
        currentList.add(0);
        res = new ArrayList<>();
        dfs(currentList,0,graph.length-1);

        return res;
    }

    public void dfs(List<Integer> currentList, int node, int target){
        if(node==target){
            res.add(new ArrayList<>(currentList));
            return;
        }

        for(int cur : adj.get(node)){
            currentList.add(cur);
            dfs(currentList, cur, target);
            currentList.remove(currentList.size()-1);
        }
    }

    public void buildAdj(int[][] graph){
        int n = graph.length;

        adj = new HashMap<>();


        for(int i=0;i<n;i++){
            adj.put(i, new ArrayList<>());
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<graph[i].length;j++){
                adj.get(i).add(graph[i][j]);
            }
        }
    }
}