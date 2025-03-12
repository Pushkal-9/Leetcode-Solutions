class Solution {
    public int maxFrequency(int[] nums, int k) {
        int res = 0;
        Map<Integer, Integer> count = new HashMap<>();
        for (int a : nums) {
            count.put(a, count.getOrDefault(a, 0) + 1);
        }

        for(int i: count.keySet()){
            int curMax=0;         
            for(int j=0;j<nums.length;j++){
                if(nums[j]==i){
                    curMax++;
                }
                if(nums[j]==k){
                    curMax--;
                }
                if(curMax<0){
                    curMax=0;
                }
                res=Math.max(res,curMax);
            }
        }

        return res + count.getOrDefault(k, 0);
    }
}