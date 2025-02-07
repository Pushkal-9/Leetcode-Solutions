class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> (b-a));

        for(int i : stones){
            pq.add(i);
        }

        while(pq.size()>1){
            int first = pq.poll();
            int second = pq.poll();

            if(first!=second){
                pq.add(Math.abs(first-second));
            }
        }

        return pq.isEmpty()? 0 : pq.poll();
    }
}