// Last updated: 18/04/2025, 16:29:41
class Solution {
    public boolean carPooling(int[][] trips, int capacity) {

        List<Event> events = new ArrayList<>();


        for(int i=0;i<trips.length;i++){
            events.add(new Event(trips[i][0],trips[i][1],true));
            events.add(new Event(trips[i][0],trips[i][2],false));
        }

        Collections.sort(events, (a,b) -> {
            if(a.time!=b.time){
                return a.time-b.time;
            }

            return a.isStart.compareTo(b.isStart);
        });

        int current = 0;

        int max=0;



        for(int i=0;i<events.size();i++){
            Event eve = events.get(i);

            if(eve.isStart){
                current += eve.passengers;
            }
            else{
                current -= eve.passengers;
            }

            max = Math.max(current, max);
        }

        return max<=capacity;
    }
}

class Event{
    int passengers;
    int time;
    Boolean isStart;

    public Event(int passengers, int time, boolean isStart){
        this.time=time;
        this.isStart=isStart;
        this.passengers = passengers;
    }
}