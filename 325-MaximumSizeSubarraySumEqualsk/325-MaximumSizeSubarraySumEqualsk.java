// Last updated: 14/04/2025, 17:08:48
class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        int[] prefixSum = new int[nums.length+1];

        for(int i=1;i<prefixSum.length;i++){
            prefixSum[i]=prefixSum[i-1] + nums[i-1];
        }

        Map<Integer,Integer> map = new HashMap<>();

        int max=0;

        for(int i=0;i<prefixSum.length;i++){
            if(map.containsKey(prefixSum[i]-k)){
                max=Math.max(max,i-map.get(prefixSum[i]-k));
            }

            if(!map.containsKey(prefixSum[i])){
                map.put(prefixSum[i],i);
            }
        }

        return max;
    }
}