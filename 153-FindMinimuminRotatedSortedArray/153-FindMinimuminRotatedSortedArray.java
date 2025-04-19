// Last updated: 19/04/2025, 15:32:49
class Solution {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length-1;

        while(low<=high){
            if(nums[high]>=nums[low]){
                return nums[low];
            }

            int mid = (high-low)/2 + low;

            if(nums[mid]>nums[high]){
                low = mid+1;
            }
            else{
                high = mid;
            }
        }

        return nums[low];
    }
}