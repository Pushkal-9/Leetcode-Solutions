class Solution {
    public int findPeakElement(int[] nums) {
        int low = 0, high = nums.length - 1;

        while (low < high) {  // No need for low <= high since low == high is a valid peak
            int mid = (low + high) / 2;

            if (nums[mid] > nums[mid + 1]) { 
                high = mid;  // Move left since peak might be mid
            } else {
                low = mid + 1;  // Move right since peak must be on right side
            }
        }
        return low; // At the end, low == high, which is the peak index
    }
}
