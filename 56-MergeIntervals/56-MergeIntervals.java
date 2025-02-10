class Solution {
    public int[][] merge(int[][] intervals) {
        List<Event> list = new ArrayList<>();

        for(int[] interval : intervals){
            list.add(new Event(interval[0], true));
            list.add(new Event(interval[1], false));
        }

        Collections.sort(list, (a,b) -> {
            if(a.value!=b.value){
                return a.value-b.value;
            }

            return Boolean.compare(b.isStart,a.isStart);
        });

        int count = 0;
        int start = 0;
        int end = 0;

        List<int[]> res = new ArrayList<>();

        for(int i=0;i<list.size();i++){
            Event event = list.get(i);

            if(event.isStart){
                if(count==0){
                    start=event.value;
                }
                count++;
            }
            else{
                count--;
                if(count==0){
                    end = event.value;
                    int[] e = {start,end};
                    res.add(e);
                }
            }
        }

        return convert(res);
    }

    public int[][] convert(List<int[]> res){
        int[][] out = new int[res.size()][2];

        for(int i=0;i<res.size();i++){
            out[i]=res.get(i);
        }

        return out;
    }
}

class Event{
    int value;
    boolean isStart;

    public Event(int value, boolean isStart){
        this.value=value;
        this.isStart=isStart;
    }
}