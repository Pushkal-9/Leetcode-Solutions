// Last updated: 02/07/2025, 20:48:53
class Solution {
    public int[] nextGreaterElements(int[] nums) {
       int[] result = new int[nums.length];

       Arrays.fill(result, -1);

       Stack<Integer> stack = new Stack<>();

       for(int i=0;i<2 * nums.length;i++){
        int idx = i%nums.length;
        if(stack.isEmpty()){
            stack.push(idx);
        }
        else{
            while(!stack.isEmpty() && nums[stack.peek()]<nums[idx]){
                result[stack.pop()] = nums[idx];
            }

            stack.push(idx);
        }
       }

       return result; 
    }
}