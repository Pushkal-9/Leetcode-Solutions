class Solution {
    public int rob(int[] nums) {

        if(nums.length==0){
            return 0;
        }

        if(nums.length==1){
            return nums[0];
        }

        int[]dp = new int[nums.length+1];

        dp[0]=0;
        dp[1]=nums[0];
        dp[2]=nums[1];

        int max = Math.max(dp[1],dp[2]);

        for(int i=3;i<dp.length;i++){
            dp[i]= nums[i-1] + Math.max(dp[i-2],dp[i-3]);
            max=Math.max(max,dp[i]);
        }

        return max;
    }
}