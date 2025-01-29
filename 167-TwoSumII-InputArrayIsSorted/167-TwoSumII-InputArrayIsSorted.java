class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int start=0;
        int end=numbers.length-1;

        int[] res = {-1,-1};

        while(start<end){
            int sum = numbers[start] + numbers[end];
            
            if(sum==target){
                res = new int[]{start+1,end+1};
                break;
            }
            else if(sum>target){
                end--;
            }
            else{
                start++;
            }
        }

        return res;
    }
}