class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int start = 1, end = 1;

        for(int i=0;i<piles.length;i++){
            end = Math.max(end,piles[i]);
        }
        
        while(start<=end){
            int mid = start + (end-start)/2;

            long cur = hours(piles,mid);

            if(cur<= (long)h){
                end=mid-1;
            }
            else{
                start=mid+1;
            }
        }

        return start;
        
    }

    public long hours(int[] piles, int speed){
        long count = 0;

        for(int i=0;i<piles.length;i++){
            count = count + Math.ceilDiv(piles[i],speed);
        }

        return count;
    }
}