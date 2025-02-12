class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        List<Event> list = new ArrayList<>();

        for(int[] interval : intervals){
            list.add(new Event(interval[0], true));
            list.add(new Event(interval[1], false));
        }

        Collections.sort(list, (a,b) -> {
            if(a.value!=b.value){
                return a.value-b.value;
            }

            return Boolean.compare(a.isStart,b.isStart);
        });

        int count=0;

        for(Event event : list){
            if(event.isStart){
                count++;
            }
            else{
                count--;
            }

            if(count>1){
                return false;
            }
        }

        return true;
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