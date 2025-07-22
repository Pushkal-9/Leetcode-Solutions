// Last updated: 22/07/2025, 00:30:30
import java.util.Arrays;

class Solution {
    public int triangleNumber(int[] nums) {
        int count = 0;
        Arrays.sort(nums);

        for (int k = nums.length - 1; k >= 2; k--) {
            int i = 0;
            int j = k - 1;

            while (i < j) {
                if (nums[i] + nums[j] > nums[k]) {
                    count += (j - i); // All elements between i and j are valid
                    j--;
                } else {
                    i++;
                }
            }
        }

        return count;
    }
}
