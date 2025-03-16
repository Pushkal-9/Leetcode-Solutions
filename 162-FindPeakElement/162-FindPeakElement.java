class Solution {
    public int findPeakElement(int[] nums) {
        int low = 0;
        int high = nums.length-1;

        if(nums.length==1){
            return 0;
        }

        while(low<=high){
            int mid = (high-low)/2 + low;
            //System.out.println(mid + " " + low + " "+ high);
            if(mid==0 && nums[mid]>nums[mid+1]){
                return mid;
            }
            else if(mid==nums.length-1 && nums[mid]>nums[mid-1]){
                return mid;
            }
            else if(mid==0){
                low = mid+1;
            }
            else if (mid==nums.length-1){
                high=mid-1;
            }
            else if(nums[mid]>nums[mid-1] && nums[mid]>nums[mid+1]){
                return mid;
            }
            else if (nums[mid]<nums[mid-1] && nums[mid]>nums[mid+1]){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }

        return -1;
    }
}