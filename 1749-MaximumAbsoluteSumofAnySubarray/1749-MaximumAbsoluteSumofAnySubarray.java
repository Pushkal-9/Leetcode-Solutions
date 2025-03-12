class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int positiveSum = 0;
        int negativeSum = 0;
        int max = 0;

        for(int i=0;i<nums.length;i++){
            positiveSum = Math.max(nums[i],nums[i]+positiveSum);
            negativeSum = Math.min(nums[i],nums[i]+negativeSum);
            max=Math.max(max,Math.max(Math.abs(positiveSum),Math.abs(negativeSum)));
        }

        return max;
    }
}