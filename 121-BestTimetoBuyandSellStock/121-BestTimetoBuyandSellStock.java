public int maxProfit(int[] prices) {
    if(prices.length<2) return 0;
    int diff[] = new int[prices.length-1];
    for(int i=1; i<prices.length; i++){
        diff[i-1] = prices[i] - prices[i-1];
    }
    return maxSubArray(diff);
}
public int maxSubArray(int[] nums) {
    if(nums.length<1) return 0;
    int preMax = 0, m = 0;
    for(int i=0; i<nums.length; i++){
        m = Math.max(m, preMax+nums[i]);
        preMax = Math.max(0, preMax+nums[i]);
    }
    return m;
}