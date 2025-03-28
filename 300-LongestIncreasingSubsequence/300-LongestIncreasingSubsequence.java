class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];

        int max=1;

        Arrays.fill(dp,1);

        for(int i=1;i<nums.length;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    dp[i]=Math.max(1+dp[j],dp[i]);
                }
            }
            max = Math.max(max,dp[i]);
        }

        return max;
    }
}