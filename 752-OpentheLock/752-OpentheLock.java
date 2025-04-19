// Last updated: 19/04/2025, 17:47:54
class Solution {
    public int openLock(String[] deadends, String target) {
        HashSet<String> visited = new HashSet<>();

        HashSet<String> dead = new HashSet<>(Arrays.asList(deadends));

        if(dead.contains("0000")){
            return -1;
        }

        visited.add("0000");

        Queue<Pair<String,Integer>> q = new LinkedList<>();

        q.add(new Pair<>("0000",0));

        while(!q.isEmpty()){
            Pair<String,Integer> p = q.poll();
            String key = p.getKey();
            int val = p.getValue();

            if(key.equals(target)){
                return val;
            }


            for(int i=0;i<4;i++){
                char ch = key.charAt(i);
                for(int j : new int[]{1, -1}){
                    char newChar = (char)((((ch - '0') + j + 10) % 10) + '0');
                    StringBuilder sb = new StringBuilder(key);
                    sb.setCharAt(i,newChar);
                    String newPath = sb.toString();

                    if(!dead.contains(newPath) && !visited.contains(newPath)){
                        Pair<String,Integer> newPair = new Pair<>(newPath, val+1);
                        visited.add(newPath);
                        q.add(newPair);
                    }
                }
            }
        }

        return -1;
    }
}