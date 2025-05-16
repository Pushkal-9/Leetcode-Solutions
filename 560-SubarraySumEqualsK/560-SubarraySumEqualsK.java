// Last updated: 15/05/2025, 19:56:06
class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int prefix = 0;

        map.put(0,1);

        int count = 0;

        for(int i=0;i<nums.length;i++){
            prefix = prefix + nums[i];
            if(map.containsKey(prefix-k)){
                count = count + map.get(prefix-k);
            }

            map.put(prefix, map.getOrDefault(prefix,0)+1);
        }

        return count;
    }
}