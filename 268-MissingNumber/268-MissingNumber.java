// Last updated: 13/04/2025, 22:29:16
class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;

        int sum = n*(n+1)/2;

        int calculatedSum = 0;

        for(int ele : nums){
            calculatedSum +=ele;
        }

        return sum - calculatedSum;
    }
}