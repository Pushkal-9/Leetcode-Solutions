// Last updated: 20/04/2025, 19:03:08
class Solution {
    List<Integer> credList;
    int n;
    public int minTransfers(int[][] transactions) {
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int[] t : transactions){
            map.put(t[0], map.getOrDefault(t[0],0) + t[2]);
            map.put(t[1], map.getOrDefault(t[1],0) - t[2]);
        }


        credList = new ArrayList<>();

        for(int val : map.values()){
            if(val!=0){
                credList.add(val);
            }
        }

        n = credList.size();

        return dfs(0);
    }

    public int dfs(int cur){

        while(cur<n && credList.get(cur)== 0){
            cur++;
        }

        if(cur == n){
            return 0;
        }

        int cost = Integer.MAX_VALUE;

        for(int next = cur+1; next<n; next++){
            if(credList.get(next) * credList.get(cur) < 0){
                credList.set(next, credList.get(next) + credList.get(cur));
                cost = Math.min(cost, 1 + dfs(cur+1));
                credList.set(next, credList.get(next) - credList.get(cur));
            }
        }

        return cost;
    }
}