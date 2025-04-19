// Last updated: 19/04/2025, 15:32:28
class Solution {
    public int findMin(int[] nums) {
        int low = 0, high = nums.length-1;

        while(low<=high){
            if(nums[low]<=nums[high]){
                return nums[low];
            }

            int mid = low + (high-low)/2;

            if(nums[high]<nums[mid]){
                low=mid+1;
            }
            else{
                high=mid;
            }
        }

        return -1;
    }
}