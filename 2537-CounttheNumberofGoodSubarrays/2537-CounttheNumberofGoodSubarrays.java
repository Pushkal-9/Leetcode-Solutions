// Last updated: 25/04/2025, 18:17:50
class Solution {
    public long countGood(int[] nums, int k) {
        long total = 0;

        int j=0;
        int subArrays = 0;

        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){

            while(subArrays<k && j<nums.length){
                int cur = nums[j];
                map.put(cur,map.getOrDefault(cur,0)+1);
                subArrays = subArrays + map.get(cur)-1;

                j++;
            }


            if(subArrays>=k){
                total = total + nums.length-j+1;
            }

            subArrays = subArrays - map.get(nums[i])+1;
            map.put(nums[i],map.getOrDefault(nums[i],0)-1);
        }

        return total;
    }
}