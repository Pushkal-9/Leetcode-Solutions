// Last updated: 19/06/2025, 17:45:22
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i : nums){
            pq.add(i);

            while(pq.size()>k){
                pq.poll();
            }
        }

        return pq.poll();
    }
}