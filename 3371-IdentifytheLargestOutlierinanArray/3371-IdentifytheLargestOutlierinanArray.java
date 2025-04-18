// Last updated: 18/04/2025, 17:02:38
class Solution {
    public int getLargestOutlier(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();

        int max = -1000;
        int total = 0;

        for(int num : nums){
            map.put(num, map.getOrDefault(num,0)+1);
            total+=num;
        }



        for(int i=0;i<nums.length;i++){
            int out = nums[i];

            int sumExludingOutlier = total - nums[i];

            if(sumExludingOutlier%2==0){
                int sumElement = sumExludingOutlier/2;

                if(map.containsKey(sumElement)){
                    if(out!=sumElement || map.get(sumElement)>1){
                        max=Math.max(out,max);
                    }
                }
            }
        }

        return max;
    }
}