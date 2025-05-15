// Last updated: 15/05/2025, 16:23:49
class Solution {
    public String smallestNumber(String pattern) {

        StringBuilder sb = new StringBuilder();

        Stack<Integer> stack = new Stack<>();

        int current = 1;

        for(int i=0;i<=pattern.length();i++){

            stack.push(current);
            current++;

            if(i==pattern.length() || pattern.charAt(i)=='I'){
                while(!stack.isEmpty()){
                    sb.append(stack.pop());
                }
            }
        }

        return sb.toString();

    }
}