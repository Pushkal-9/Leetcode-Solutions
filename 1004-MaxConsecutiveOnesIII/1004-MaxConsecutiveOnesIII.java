// Last updated: 18/04/2025, 16:48:29
class Solution {
    public int longestOnes(int[] nums, int k) {
        int maxLength=0;

        int start = 0;
        int end = 0;

        int current = 0;

        int max=0;

        while(end<nums.length){
            if(nums[end]==1){
                max=Math.max(max,end-start+1);
                end++;
            }
            else if(current>=k){
                if(nums[start]==0){
                    current--;
                }
                start++;
            }
            else{
                max=Math.max(max,end-start+1);
                end++;
                current++;
            }
        }

        return max;
    }
}