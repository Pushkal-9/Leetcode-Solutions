// Last updated: 20/04/2025, 20:16:55
class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);

        int left = 0;
        long curr = 0;
        int max = 0;

        for(int right = 0; right < nums.length; right++){
            curr += nums[right];

            // Total cost to make all elements in the window equal to nums[right]
            while((long)(right - left + 1) * nums[right] - curr > k){
                curr -= nums[left];
                left++;
            }

            max = Math.max(max, right - left + 1);
        }

        return max;
    }
}
