// Last updated: 19/04/2025, 19:27:38
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] result = new int[nums.length];

        Arrays.fill(result,-1);

        Stack<Integer> stack = new Stack<>();

        for(int i=0;i<2*nums.length - 1;i++){
            
            int index = i%(nums.length);

            if(stack.isEmpty()){
                stack.push(index);
            }
            else{

                while(!stack.isEmpty() && nums[stack.peek()]<nums[index]){
                    result[stack.pop()] = nums[index];
                }

                stack.add(index);
            }
        }

        return result;
    }
}