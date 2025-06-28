// Last updated: 28/06/2025, 16:21:16
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int startIndex = findStartIndex(nums,target);
        int endIndex = findEndIndex(nums,target);

        int[] res = new int[2];
        res[0] = startIndex;
        res[1] = endIndex;

        return res;
    }

    public int findStartIndex(int[] nums, int target) {
        int low = 0;
        int high = nums.length -1;

        while(low<=high){
            int mid = (high-low)/2 + low;

            if(nums[mid] == target && (mid ==0 || nums[mid-1]<nums[mid]) ){
                return mid;
            }
            else if(nums[mid] >= target){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }

        return -1;
    }

    public int findEndIndex(int[] nums, int target) {
        int low = 0;
        int high = nums.length -1;

        while(low<=high){
            int mid = (high-low)/2 + low;

            if(nums[mid] == target && (mid == nums.length-1 || nums[mid+1]>nums[mid]) ){
                return mid;
            }
            else if(nums[mid] <= target){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }

        return -1;
    }
}