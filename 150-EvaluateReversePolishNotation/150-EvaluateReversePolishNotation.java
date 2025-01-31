class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for(int i=0;i<tokens.length;i++){
            String str = tokens[i];

            if(str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/")){
                int second = stack.pop();
                int first = stack.pop();

                if(str.equals("+")){
                    stack.push(first+second);
                }
                else if(str.equals("-")){
                    stack.push(first-second);
                }
                else if(str.equals("*")){
                    stack.push(first*second);
                }
                else if(str.equals("/")){
                    stack.push(first/second);
                }
            }
            else{
                stack.push(Integer.parseInt(str));
            }
        }

        return stack.pop();
    }
}