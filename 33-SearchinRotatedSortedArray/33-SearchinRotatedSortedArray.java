// Last updated: 19/04/2025, 12:40:55
class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;

        while(low<=high){

            int mid = (high-low)/2 + low;

            if(nums[mid]==target){
                return mid;
            }
            else if(nums[mid]<nums[high]){
                if(nums[mid]<target && target <= nums[high]){
                    low = mid+1;
                }
                else{
                    high = mid-1;
                }
            }
            else{
                if(nums[low]<=target && target < nums[mid]){
                    high = mid-1;
                }
                else{
                    low = mid+1;
                }
            }
        }

        return -1;
    }
}