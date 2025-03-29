// Last updated: 28/03/2025, 22:40:23
class Solution {
    private List<Integer> res = new ArrayList<>();

    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        HashMap<Integer,List<Integer>> adj = buildAdj(pid,ppid);

        dfs(adj,kill);

        return res;
    }

    public void dfs(HashMap<Integer,List<Integer>> adj, int node){
        res.add(node);
        for(int child : adj.get(node)){
            dfs(adj,child);
        }
    }

    public HashMap<Integer,List<Integer>> buildAdj(List<Integer> pid, List<Integer> ppid){

        HashMap<Integer,List<Integer>> adj = new HashMap<>();
        for(int i : pid){
            adj.put(i,new ArrayList<>());
        }

        for(int i=0;i<ppid.size();i++){
            int node = ppid.get(i);
            if(node==0){
                continue;
            }

            adj.get(node).add(pid.get(i));
        }

        return adj;
    }
}