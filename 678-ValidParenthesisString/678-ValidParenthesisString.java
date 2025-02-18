class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                stack.push(i);
            }
            else if(s.charAt(i)==')'){
                if(stack.isEmpty()){
                    if(stack2.isEmpty()){
                        return false;
                    }
                    stack2.pop();
                }
                else{
                    stack.pop();
                }
            }
            else if(s.charAt(i)=='*'){
                stack2.push(i);
            }
        }

        if(!stack.isEmpty() && stack.size()>stack2.size()){
            System.out.println(stack.pop());
            System.out.println(stack2.size());
            return false;
        }

        while(!stack.isEmpty()){
            if(stack.pop()>stack2.pop()){
                return false;
            }
        }

        return true;
    }
}