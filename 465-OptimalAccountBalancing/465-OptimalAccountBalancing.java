// Last updated: 23/05/2025, 00:03:39
class Solution {
    int n;
    public int minTransfers(int[][] transactions) {
       HashMap<Integer, Integer> map = new HashMap<>();


       for(int[] t : transactions){
        map.put(t[0], map.getOrDefault(t[0],0) + t[2]);
        map.put(t[1], map.getOrDefault(t[1],0) - t[2]);
       } 

       List<Integer> list = new ArrayList<>();

       for(int key : map.keySet()){
        if(map.get(key)!=0){
            list.add(map.get(key));
        }
       }
       
       n = Integer.MAX_VALUE;

       return dfs(list,0);
    }

    public int dfs(List<Integer> list, int cur){
        while(cur < list.size() && list.get(cur)==0){
            cur++;
        }

        if(cur==list.size()){
            return 0;
        }

        for(int next = cur+1; next<list.size(); next++){
            if(list.get(cur) * list.get(next) < 0 ){
                list.set(next, list.get(cur) + list.get(next));
                n = Math.min(n,1+ dfs(list,cur+1));
                list.set(next, list.get(next) - list.get(cur));
            }
        }

        return n;
    }
}