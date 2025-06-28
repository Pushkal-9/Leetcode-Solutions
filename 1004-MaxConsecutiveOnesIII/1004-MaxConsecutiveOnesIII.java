// Last updated: 28/06/2025, 12:57:46
class Solution {
    public int longestOnes(int[] nums, int k) {
        int start = 0;
        int end = 0;

        int max = 0;

        int count = 0;

        while(end<nums.length){
            if(nums[end] == 0){
                if(count < k){
                    count++;
                    max = Math.max(end-start+1, max);
                    end++;
                }
                else{
                    if(nums[start]==0){
                        count--;
                    }
                    start++;
                }
            }
            else{
                max = Math.max(end-start+1, max);
                end++;
            }
        }

        return max;
    }
}