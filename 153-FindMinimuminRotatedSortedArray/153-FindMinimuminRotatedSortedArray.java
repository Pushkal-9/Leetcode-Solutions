class Solution {
    public int findMin(int[] nums) {
        int low = 0, high = nums.length-1;

        while(low<=high){
            if(nums[low]<=nums[high]){
                return nums[low];
            }

            int mid = low + (high-low)/2;

            if(nums[low]>nums[mid]){
                high=mid;
            }
            else{
                low=mid+1;
            }
        }

        return -1;
    }
}