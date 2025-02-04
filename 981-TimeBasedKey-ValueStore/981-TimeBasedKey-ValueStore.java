class TimeMap {
    HashMap<String,List<Pair>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        Pair p = new Pair(timestamp,value);
        if(!map.containsKey(key)){
            List<Pair> list = new ArrayList<>();
            list.add(p);
            map.put(key,list);
        }
        else{
            map.get(key).add(p);
        }
    }
    
    public String get(String key, int timestamp) {
        List<Pair> list = map.get(key);
        
        String res = "";

        if(list==null || list.isEmpty()){
            return res;
        }

        int start=0;
        int end = list.size()-1;

        while(start<=end){
            int mid = start + (end-start)/2;

            if(timestamp==list.get(mid).time){
                return list.get(mid).value;
            }
            else if(timestamp>list.get(mid).time){
                res = list.get(mid).value;
                start = mid+1;
            }
            else{
                end=mid-1;
            }
        }

        return res;
    }
}

class Pair{
    public int time;
    public String value;

    public Pair(int time, String value){
        this.time = time;
        this.value = value;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */