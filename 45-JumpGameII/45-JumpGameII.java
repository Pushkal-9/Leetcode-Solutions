class Solution {
    public int jump(int[] nums) {
        int[] dp = new int[nums.length+1];

        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;

        for(int i=0;i<nums.length;i++){
            for(int j=1;j<=nums[i] && i+j<=nums.length;j++){
                dp[i+j]= Math.min(dp[i+j],dp[i]+1);
            }
            
            //System.out.println(dp[i]+ " " + i);
        }

        return dp[nums.length-1];
    }
}