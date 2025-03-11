class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        int i=0;

        for (int asteroid : asteroids) {
            boolean destroyed = false;

            while (!stack.isEmpty() && asteroid < 0 && stack.peek() > 0) {
                if (stack.peek() < Math.abs(asteroid)) {
                    stack.pop();
                    continue;
                } else if (stack.peek() == Math.abs(asteroid)) {
                    stack.pop();
                }
                destroyed = true;
                break;
            }

            if (!destroyed) {
                stack.push(asteroid);
            }
        }

        int[] res = new int[stack.size()];

        for(int j=res.length-1;j>=0;j--){
            res[j]=stack.pop();
        }

        return res;
    }
}