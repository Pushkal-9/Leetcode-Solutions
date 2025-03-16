class Solution {
    public int maxSubarraySumCircular(int[] nums) {

        int[] suffix = new int[nums.length];
        int[] prefix = new int[nums.length];
        int[] prefixMax = new int[nums.length];
        int[] suffixMax = new int[nums.length];

        prefix[0]=nums[0];
        prefixMax[0]=nums[0];

        for(int i=1;i<nums.length;i++){
            prefix[i]=prefix[i-1]+nums[i];
            prefixMax[i]=Math.max(prefixMax[i-1],prefix[i]);
        }

        suffix[nums.length-1]=nums[nums.length-1];
        suffixMax[nums.length-1]=nums[nums.length-1];

        for(int i=nums.length-2;i>=0;i--){
            suffix[i]=suffix[i+1]+nums[i];
            suffixMax[i]=Math.max(suffixMax[i+1],suffix[i]); 
        }

        int maxSum=Integer.MIN_VALUE;

        for(int i=0;i<nums.length-1;i++){
            maxSum=Math.max(maxSum,prefixMax[i]+suffixMax[i+1]);
            // System.out.println(maxSum + " " + i + " "+ prefix[i] + " " + suffix[i+1]);
        }


        int max=Integer.MIN_VALUE;
        int currentMax=0;

        for(int i=0;i<nums.length;i++){
            currentMax = Math.max(currentMax+nums[i],nums[i]);
            max=Math.max(currentMax,max);
        }

        return Math.max(max,maxSum);
    }
}