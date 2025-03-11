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
            String pattern = "";
            HashSet<String> set = new HashSet<>();
            for(int i=0;i<list.size()-2;i++){
                pattern=list.get(i).site + "#";
                for(int j=i+1;j<list.size()-1;j++){
                    String pattern2 = pattern + list.get(j).site + "#";
                    for(int k=j+1;k<list.size();k++){
                        String pattern3 = pattern2 + list.get(k).site;
                        if(!set.contains(pattern3)){
                            score.put(pattern3,score.getOrDefault(pattern3,0)+1);
                            set.add(pattern3);
                            //System.out.println(pattern3 + " " + score.get(pattern3));
                        }
                    }
                }
            }
        }

        List<Pair> pList = new ArrayList<>();

        for(String str : score.keySet()){
            pList.add(new Pair(str,score.get(str)));
        }

        Collections.sort(pList, (a,b) -> {
            if(a.time!=b.time){
                return b.time-a.time;
            }
            return a.site.compareTo(b.site);
        });

        String[] res = pList.get(0).site.split("#");

        List<String> resList = new ArrayList<>();

        for(String site : res){
            resList.add(site);
        }

        return resList;
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