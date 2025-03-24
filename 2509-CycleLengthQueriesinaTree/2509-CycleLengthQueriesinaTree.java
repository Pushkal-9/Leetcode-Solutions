// Last updated: 23/03/2025, 21:39:11
class Solution {
    public int[] cycleLengthQueries(int n, int[][] queries) {
        int[] res = new int[queries.length];

        for(int i=0;i<queries.length;i++){
            res[i]= length(queries[i][0],queries[i][1]);
        }

        return res;
    }

    public int length(int x, int y){
        HashMap<Integer,Integer> map = new HashMap<>();
        int level = 0;
        while(x>=1){
            map.put(x,level);
            x=x/2;
            level++;
        }

        level=0;

        while(!map.containsKey(y)){
            y=y/2;
            level++;
        }

        return level + map.get(y)+1;
    }
}