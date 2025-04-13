// Last updated: 13/04/2025, 13:47:51
class Solution {
    public int minStartValue(int[] nums) {
        int min = Integer.MAX_VALUE;

        int sum = 0;

        for(int i : nums){
            sum = sum + i;
            min=Math.min(min,sum);
        }

        if(min>0){
            return 1;
        }

        return Math.abs(min)+1;
    }
}