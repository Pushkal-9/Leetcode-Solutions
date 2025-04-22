// Last updated: 22/04/2025, 12:30:38
class Solution {
    int total, case1, case2;
    public int minOperations(int[] nums) {
        int total = 0, case1 = 0, case2 = 0;

        for(int i=0;i<nums.length;i++){
            int n = nums[i];
            int op1 = 0;
            int op2 = 0;

            while(n!=0){
                if(n%2==0){
                    n=n/2;
                    op1++;
                }
                else{
                    n=n-1;
                    op2++;
                }
            }
            case1 = Math.max(case1,op1);
            case2 = case2 + op2;
        }

        return case1+case2;
    }
}