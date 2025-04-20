// Last updated: 19/04/2025, 19:08:04
class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        int start = 0;
        while(start<asteroids.length){
            int aster = asteroids[start];

            if(stack.isEmpty()){
                stack.push(aster);
                start++;
            }
            else if(stack.peek()>0 && aster<0){
                if(Math.abs(aster)<stack.peek()){
                    start++;
                    continue;
                }
                else if(Math.abs(aster)==stack.peek()){
                    start++;
                    stack.pop();
                    continue;   
                }

                stack.pop();
            }
            else{
                stack.push(aster);
                start++;
            }
        }

        int[] res = new int[stack.size()];

        int i=0;

        for(int ele : stack){
            res[i]=ele;
            i++;
        }

        return res;
    }
}