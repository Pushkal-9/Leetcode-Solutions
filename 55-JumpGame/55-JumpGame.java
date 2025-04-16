// Last updated: 16/04/2025, 11:55:52
class Solution {
    public boolean canJump(int[] nums) {
        int max=0;

        for(int i=0;i<nums.length;i++){
            if(max>=i){
                max=Math.max(max,i+nums[i]);
            }
            else{
                return false;
            }
        }

        return true;
    }
}