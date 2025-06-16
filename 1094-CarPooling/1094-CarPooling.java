// Last updated: 16/06/2025, 16:34:07
class Solution {
    public boolean carPooling(int[][] trips, int capacity) {

        List<Event> events = new ArrayList<>();


        for(int i=0;i<trips.length;i++){
            events.add(new Event(trips[i][0],trips[i][1],true));
            events.add(new Event(trips[i][0],trips[i][2],false));
        }

        Collections.sort(events);

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

            if(max>capacity){
                return false;
            }
        }

        return true;
    }
}

class Event implements Comparable<Event>{
    int passengers;
    int time;
    Boolean isStart;

    public Event(int passengers, int time, boolean isStart){
        this.time=time;
        this.isStart=isStart;
        this.passengers = passengers;
    }

    @Override
    public int compareTo(Event other) {

        if(this.time!=other.time){
            return this.time - other.time;
        }
        return this.isStart.compareTo(other.isStart);
    }
}