// Last updated: 29/06/2025, 12:27:28
class Solution {
    private Map<Integer,List<Integer>> indices;
    private Random rand;

    public Solution(int[] nums) {
        indices = new HashMap<>();
        rand = new Random();

        for(int i=0; i<nums.length;i++){
            if(!indices.containsKey(nums[i])){
                indices.put(nums[i], new ArrayList<>());
            }

            indices.get(nums[i]).add(i);
        }
    }
    
    public int pick(int target) {
        List<Integer> idx = indices.get(target);
        int total = idx.size();

        int randomIdx = rand.nextInt(total);

        return idx.get(randomIdx);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */