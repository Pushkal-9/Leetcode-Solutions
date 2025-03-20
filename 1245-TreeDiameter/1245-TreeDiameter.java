class Solution {
            int max = 0;
        int farthest=0;
    public int treeDiameter(int[][] edges) {
        HashMap<Integer,List<Integer>> adj = new HashMap<>();

        if(edges.length==0){
            return 0;
        }

        for(int[] edge : edges){
            int from = edge[0];
            int to = edge[1];

            if(!adj.containsKey(from)){
                adj.put(from, new ArrayList<>());
            }
            if(!adj.containsKey(to)){
                adj.put(to, new ArrayList<>());
            }

            adj.get(from).add(to);
            adj.get(to).add(from);
        }

        boolean[] vis = new boolean[edges.length+1];

        dfs(adj,vis,0,0);
        vis = new boolean[edges.length+1];
        max=0;
        dfs(adj,vis,farthest,0);

        return max;

    }

    public void dfs(HashMap<Integer,List<Integer>> adj,boolean[] vis, int cur, int dist){
        if(max<dist)
        {
            max=dist;
            farthest=cur;
        }

        vis[cur]=true;

        for(int v : adj.get(cur)){
            if(!vis[v]){
                dfs(adj,vis,v,dist+1);
            }
        }
    }
}