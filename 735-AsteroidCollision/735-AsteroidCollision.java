class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        int i=0;

        while(i<asteroids.length){
          if(stack.isEmpty()){
            stack.push(asteroids[i]);
            i++;
            continue;
          }  

          if(asteroids[i]>0){
            stack.push(asteroids[i]);
            i++;
            continue;
          }
          else{
            if(stack.peek()<0){
                stack.push(asteroids[i]);
                i++;
                continue;             
            }
            else if(stack.peek()==Math.abs(asteroids[i])){
                stack.pop();
                i++;
                continue;
            }
            else if(stack.peek()>Math.abs(asteroids[i])){
                i++;
                continue;
            }
            else{
                while(!stack.isEmpty() && stack.peek()>0 && stack.peek()<Math.abs(asteroids[i])){
                    stack.pop();
                }
                continue;    
            }
          }
        }

        int[] res = new int[stack.size()];

        for(int j=res.length-1;j>=0;j--){
            res[j]=stack.pop();
        }

        return res;
    }
}