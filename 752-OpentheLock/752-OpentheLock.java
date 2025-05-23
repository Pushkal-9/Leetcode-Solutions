// Last updated: 23/05/2025, 01:25:06
class Solution {
    public int openLock(String[] deadends, String target) {
        HashSet<String> ends = new HashSet<>();
        HashSet<String> vis = new HashSet<>();

        for(String end : deadends){
            ends.add(end);
        }

        if(ends.contains("0000")){
            return -1;
        }

        Queue<Pair<String, Integer>> q = new LinkedList<>();

        q.add(new Pair("0000",0));
        vis.add("0000");

        int[] steps = {-1,1};

        while(!q.isEmpty()){
            Pair<String,Integer> p = q.poll();
            String key = p.getKey();
            int val = p.getValue();

            if(key.equals(target)){
                return val;
            }

            for(int i : steps){
                
                for(int j=0; j<4; j++){
                    StringBuilder sb = new StringBuilder();
                    sb.append(key.substring(0,j));
                    sb.append(nextCharacter(key.charAt(j),i));
                    sb.append(key.substring(j+1,4));

                    String newKey = sb.toString();
                    if(!ends.contains(newKey) && !vis.contains(newKey)){
                        q.add(new Pair(newKey,val+1));
                        vis.add(newKey);
                    }
                }
            }
        }

        return -1;
    }

    public char nextCharacter(char ch, int val){
        if(ch=='9' && val == 1){
            return '0';
        }

        if(ch=='0' && val == -1){
            return '9';
        }

        return (char)(ch + val);
    }
}