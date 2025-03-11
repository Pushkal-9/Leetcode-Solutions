class Solution {
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        HashMap<String,List<Pair>> map = new HashMap<>();
        for(int i=0;i<username.length;i++){
            Pair p = new Pair(website[i],timestamp[i]);
            if(!map.containsKey(username[i])){
                map.put(username[i], new ArrayList<>());
            }
            map.get(username[i]).add(p);
        }

        HashMap<String,Integer> score = new HashMap<>();

        for(List<Pair> list : map.values()){
            Collections.sort(list, (a,b)-> (a.time-b.time));
            HashSet<String> set = new HashSet<>();
            for(int i=0;i<list.size()-2;i++){
                for(int j=i+1;j<list.size()-1;j++){
                    for(int k=j+1;k<list.size();k++){
                        String pattern = list.get(i).site + "#" + list.get(j).site + "#" + list.get(k).site;
                        if(!set.contains(pattern)){
                            score.put(pattern,score.getOrDefault(pattern,0)+1);
                            set.add(pattern);
                        }
                    }
                }
            }
        }


        String mostVisited = "";
        int maxFreq = 0;

        for (Map.Entry<String, Integer> entry : score.entrySet()) {
            String pattern = entry.getKey();
            int freq = entry.getValue();

            if (freq > maxFreq || (freq == maxFreq && pattern.compareTo(mostVisited) < 0)) {
                mostVisited = pattern;
                maxFreq = freq;
            }
        }
        return Arrays.asList(mostVisited.split("#"));
    }
}

class Pair{
    String site;
    int time;

    public Pair(String site, int time){
        this.site=site;
        this.time=time;
    }
}