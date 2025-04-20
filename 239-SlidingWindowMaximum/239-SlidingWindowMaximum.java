// Last updated: 20/04/2025, 17:32:08
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new ArrayDeque<>();

        int[] res = new int[nums.length-k+1];

        for(int i=0;i<nums.length;i++){

            while(!deque.isEmpty() && i-k>=deque.getFirst()){
                deque.pollFirst();
            }

            // while(!deque.isEmpty() && nums[deque.getFirst()]<=nums[i]){
            //     deque.pollFirst();
            // }

            while(!deque.isEmpty() && nums[deque.getLast()]<=nums[i]){
                deque.pollLast();
            }

            deque.addLast(i);

            if(i+1>=k){
                res[i-k+1]=nums[deque.getFirst()];
            }

        }

        return res;
    }
}