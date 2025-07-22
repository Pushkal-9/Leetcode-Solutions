// Last updated: 22/07/2025, 00:16:18
class Solution {
    public int findNumberOfLIS(int[] nums) {
        int total = 0;

        int max = 1;

        int[] dp = new int[nums.length];
        int[] LIS = new int[nums.length];

        Arrays.fill(dp,1);
        Arrays.fill(LIS,1);

        for(int i=1;i<nums.length;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    if(dp[i] < dp[j]+1){
                        LIS[i] = LIS[j];
                        dp[i] = dp[j]+1;
                    }
                    else if(dp[i] == dp[j]+1){
                        LIS[i] = LIS[i]+LIS[j];
                    }
                }
            }

            if(dp[i]>max){
                max = dp[i];
            }
        }

        for(int i=0;i<dp.length;i++){
            if(max == dp[i]){
                total = total + LIS[i];
            }
        }

        return total;
    }
}