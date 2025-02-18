class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                stack1.push(i);
            }
            else if(s.charAt(i)==')'){
                if(stack1.isEmpty()){
                    if(stack2.isEmpty()){
                        return false;
                    }

                    stack2.pop();
                }
                else{
                    stack1.pop();
                }
            }
            else if(s.charAt(i)=='*'){
                stack2.push(i);
            }
        }

        if(!stack1.isEmpty() && stack1.size()>stack2.size()){
            return false;
        }

        while(!stack1.isEmpty()){
            if(stack1.pop()>stack2.pop()){
                return false;
            }
        }

        return true;
    }
}