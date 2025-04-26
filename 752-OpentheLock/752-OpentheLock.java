// Last updated: 26/04/2025, 14:35:43
class Solution {
    public int openLock(String[] deadends, String target) {
        HashSet<String> dead = new HashSet<>();
        HashSet<String> vis = new HashSet<>();
        for(String deadend : deadends){
            dead.add(deadend);
        }

        if(dead.contains("0000")){
            return -1;
        }

        Queue<Pair<String,Integer>> q = new LinkedList<>();

        q.add(new Pair<>("0000",0));
        vis.add("0000");

        int[] steps = {-1,1};


        while(!q.isEmpty()){
            Pair<String, Integer> p = q.poll();

            String key = p.getKey();
            int dist = p.getValue();

            if(key.equals(target)){
                return dist;
            }

            for(int i=0;i<4;i++){
                for(int step : steps){
                    String comb = nextCombination(key,i,step);

                    if(!dead.contains(comb) && !vis.contains(comb)){
                        Pair<String,Integer> pair = new Pair<>(comb, dist+1);
                        q.add(pair);
                        vis.add(comb);
                    }
                }
            }
        }

        return -1;
    }

    public String nextCombination(String comb, int pos, int step){
        char ch = comb.charAt(pos);

        char mod;

        if(step==-1 && ch=='0'){
            mod = '9';
        }
        else if(step==1 && ch=='9'){
            mod = '0';
        }
        else{
            mod = (char)(ch + step);
        }

        StringBuilder sb = new StringBuilder();

        sb.append(comb.substring(0,pos));
        sb.append(mod);
        sb.append(comb.substring(pos+1,comb.length()));

        return sb.toString();
    }
}