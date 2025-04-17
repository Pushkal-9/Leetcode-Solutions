// Last updated: 17/04/2025, 13:31:55
class Solution {
    public int minimumCost(int n, int[][] connections) {

        HashMap<Integer,ArrayList<Pair>>  adj = constructAdjList(connections,n);

        HashSet<Integer> vis = new HashSet<>();

        int cost = 0;

        PriorityQueue<Pair> q = new PriorityQueue<>((a,b) -> (a.cost-b.cost));

        q.add(new Pair(1,0));

        while(!q.isEmpty()){
            Pair p = q.poll();

            if(vis.contains(p.vertex)){
                continue;
            }

            vis.add(p.vertex);
            cost =cost + p.cost;

            for(Pair v : adj.get(p.vertex)){
                if(vis.contains(v.vertex)){
                    continue;
                }
                q.add(v);
            }
        }

        if(vis.size()!=n){
            return -1;
        }

        return cost;
        
    }

    public HashMap<Integer,ArrayList<Pair>> constructAdjList(int[][] edges, int n){
        HashMap<Integer,ArrayList<Pair>> adj = new HashMap<>();

        for(int i=1;i<=n;i++){
            adj.put(i, new ArrayList<Pair>());
        }

        for(int [] edge : edges){
            int src = edge[0];
            int dest = edge[1];
            int cost = edge[2];

            adj.get(src).add(new Pair(dest,cost));
            adj.get(dest).add(new Pair(src,cost));
        }

        return adj;
    }
}

class Pair{
    int vertex;
    int cost;

    public Pair(int v, int c){
        this.vertex=v;
        this.cost=c;
    }
}