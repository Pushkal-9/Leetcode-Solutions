class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        Integer[][] dp = new Integer[nums.length][3000];
        return helper(nums,target,0,0,dp);
    }

    public int helper(int[] nums, int target, int index, int sum, Integer[][] dp){
        if(index>=nums.length){
            if(sum==target){
                return 1;
            }
            return 0;
        }

        if(dp[index][sum+1000]!=null){
            return dp[index][sum];
        }

        int left = helper(nums,target,index+1,sum+nums[index],dp);
        int right= helper(nums,target,index+1,sum-nums[index],dp);  

        return left+right;
    }
}