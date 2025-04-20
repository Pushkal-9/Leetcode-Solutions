// Last updated: 20/04/2025, 17:03:54
class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        Interval[] intervals = new Interval[startTime.length];

        for(int i=0; i<intervals.length; i++){
            intervals[i] = new Interval(startTime[i], endTime[i], profit[i]);
        }

        Arrays.sort(intervals, (a,b) -> a.end-b.end);

        int maxProfit = 0;

        int[] mem = new int[profit.length];

        mem[0] = intervals[0].profit;


        for(int i=1;i<intervals.length;i++){
            int prevOptimalIndex = findPreviousOptimalIndex(intervals, i);
            int current = intervals[i].profit;

            if(prevOptimalIndex != -1)
                current = mem[prevOptimalIndex] + current;

            mem[i] = Math.max(current, mem[i-1]);
        }

        return mem[intervals.length-1];
    }


    public int findPreviousOptimalIndex(Interval[] intervals, int index){
        int low = 0;
        int high = index-1;

        int result = -1;

        while(low<=high){

            int mid = (high-low)/2 + low;

            if(intervals[mid].end <= intervals[index].start){
                result = mid;
                low = mid+1;
            }
            else{
                high = mid -1;
            }
        }

        return result;
    }
}

class Interval{
    int start;
    int end;
    int profit;

    public Interval(int start, int end, int profit){
        this.start=start;
        this.end=end;
        this.profit=profit;
    }
}