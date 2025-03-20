class Solution {
    public boolean validTree(int n, int[][] edges) {
        HashMap<Integer,List<Integer>> adj = buildAdj(edges,n);

        boolean[] vis = new boolean[n];

        if(dfs(adj,vis,0,-1)){
            return false;
        }

        for(int i=0;i<n;i++){
            if(!vis[i]){
                return false;
            }
        }

        return true;
    }

    public boolean dfs(HashMap<Integer,List<Integer>> adj, boolean[] vis, int node, int parent){
        vis[node]=true;

        for(int neighbor : adj.get(node)){
            if(!vis[neighbor]){
                if(dfs(adj,vis,neighbor,node)){
                    return true;
                }
            }
            else if(neighbor!=parent){
                return true;
            }
        }

        return false;
    }

    public HashMap<Integer,List<Integer>> buildAdj(int[][] edges, int n){
        HashMap<Integer, List<Integer>> adj = new HashMap<>();

        for(int i=0;i<n;i++){
            adj.put(i, new ArrayList<>());
        }

        for(int[] edge : edges){
            int from = edge[0];
            int to = edge[1];

            adj.get(from).add(to);
            adj.get(to).add(from);
        }

        return adj;
    }
}