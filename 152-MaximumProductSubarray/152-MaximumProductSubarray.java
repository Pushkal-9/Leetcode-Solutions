class Solution {
    public int maxProduct(int[] nums) {
        double[] min = new double[nums.length];
        double[] dp = new double[nums.length];

        min[0]=nums[0];
        dp[0]= nums[0];

        double max=nums[0];

        for(int i=1;i<nums.length;i++){
            dp[i]= Math.max(nums[i]*min[i-1],Math.max(nums[i]*dp[i-1],nums[i]));
            min[i]= Math.min(nums[i]*min[i-1],Math.min(nums[i]*dp[i-1],nums[i]));
                    System.out.println(dp[i] + " " + min[i]);
            max=Math.max(max,dp[i]);
        }

        return (int)max;
    }
}