class Solution {
    public int minMeetingRooms(int[][] intervals) {
        List<Event> list = new ArrayList<>();

        for(int[] interval : intervals){
            list.add(new Event(interval[0],true));
            list.add(new Event(interval[1],false));
        }

        Collections.sort(list, (a,b) -> {
            if(a.value!=b.value){
                return a.value-b.value;
            }

            return Boolean.compare(a.isStart,b.isStart);
        });

        int count=0;

        int max=0;

        for(Event event : list){
            if(event.isStart){
                count++;
                max=Math.max(count,max);
            }
            else{
                count--;
            }
        }

        return max;
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