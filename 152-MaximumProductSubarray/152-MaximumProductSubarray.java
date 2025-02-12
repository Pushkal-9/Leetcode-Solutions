class Solution {
    public int maxProduct(int[] nums) {
        int[] max = new int[nums.length+1];
        int[] min = new int[nums.length+1];

        if(nums.length==1){
            return nums[0];
        }

        int globalMax = nums[0];
        min[0]=1;
        max[1]=1;

        for(int i=1;i<max.length;i++){
            min[i] = Math.min(Math.min(max[i-1]*nums[i-1],min[i-1]*nums[i-1]),nums[i-1]);
            max[i]=Math.max(Math.max(nums[i-1],nums[i-1]*max[i-1]),nums[i-1]*min[i-1]);
            globalMax=Math.max(globalMax,max[i]);
        }


        return globalMax;
    }
}