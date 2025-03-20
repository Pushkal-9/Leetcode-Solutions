class Solution {
    int minIndex=-1;
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        HashMap<Integer,List<Integer>> adj = buildAdj(richer);

        boolean[] vis = new boolean[quiet.length];

        int[] res = new int[quiet.length];

        for(int i=0;i<res.length;i++){
            minIndex = i;
            int cur = i;
            vis = new boolean[quiet.length];
            dfs(adj,vis,cur,quiet);
            res[i]=minIndex;
        }

        return res;
    }

    public void dfs(HashMap<Integer,List<Integer>> adj, boolean[] vis, int cur, int[] quiet){
        if(quiet[cur]<quiet[minIndex]){
            minIndex=cur;
        }

        vis[cur]=true;

        if(!adj.containsKey(cur)){
            return;
        }

        for(int v : adj.get(cur)){
            if(!vis[v]){
                dfs(adj,vis,v,quiet);
            }
        }
    }

    public HashMap<Integer,List<Integer>> buildAdj(int[][] richer){
        HashMap<Integer,List<Integer>> adj = new HashMap<>();

        for(int[] edge : richer){
            if(!adj.containsKey(edge[1])){
                adj.put(edge[1], new ArrayList<>());
            }

            adj.get(edge[1]).add(edge[0]);
        }

        return adj;
    }
}