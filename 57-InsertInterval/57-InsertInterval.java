class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<Event> list = new ArrayList<>();

        for(int[] interval : intervals){
            Event start = new Event(interval[0], true);
            Event end = new Event(interval[1], false);
            list.add(start);
            list.add(end);
        }

        list.add(new Event(newInterval[0], true));

        list.add(new Event(newInterval[1], false));

        Collections.sort(list, (a,b) -> {
            if(a.value!=b.value){
                return a.value-b.value;
            }
            return Boolean.compare(b.isStart,a.isStart);
        });

        int count=0;
        int start=0;
        int end=0;

        List<int[]> res = new ArrayList<>();

        for(int i=0;i<list.size();i++){
            if(list.get(i).isStart){
                if(count==0){
                    start=list.get(i).value;
                }
                count++;
            }
            if(!list.get(i).isStart){
                count--;
                if(count==0){
                    end=list.get(i).value;
                    int[] e = new int[2];
                    e[0]=start;
                    e[1]=end;
                    res.add(e);
                }
            }
        }

        return convert(res);
    }

    public int[][] convert(List<int[]> event){
        int[][] out = new int[event.size()][2];

        for(int i=0;i<event.size();i++){
            out[i]=event.get(i);
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