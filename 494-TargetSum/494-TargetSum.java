class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return helper(nums,target,0,0,0);
    }

    public int helper(int[] nums, int target, int index, int sum, int total){
        if(index>=nums.length){
            if(sum==target){
                total=total+1;
            }
            return total;
        }

        total = helper(nums,target,index+1,sum+nums[index],total);
        total = helper(nums,target,index+1,sum-nums[index],total);

        return total;
    }
}