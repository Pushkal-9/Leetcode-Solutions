// Last updated: 20/04/2025, 20:19:11
class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);

        int left = 0;

        long curr = 0;

        int max = 0;

        for(int right = 0; right<nums.length; right++){

            int target = nums[right];
            curr = curr + target;

            while( (long)(right-left+1) * target - curr > k){
                curr = curr - nums[left];
                left++;
            }

            max = Math.max(max,right-left+1);
        }

        return max;
    }
}