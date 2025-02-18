class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if((hand.length)%groupSize!=0){
            return false;
        }

        HashMap<Integer,Integer> count = new HashMap<>();
        SortedSet<Integer> set = new TreeSet<>();

        for(int i : hand){
            count.put(i, count.getOrDefault(i,0)+1);
            set.add(i);
        }

        while(!set.isEmpty()){
            int h = set.first();

            for(int i=0;i<groupSize;i++){
                if(count.containsKey(h+i)){
                    count.put(h+i,count.get(h+i)-1);
                    if(count.get(h+i)==0){
                        count.remove(h+i);
                        set.remove(h+i);
                    }
                }
                else{
                    return false;
                }
            }
        }

        return true;


    }
}