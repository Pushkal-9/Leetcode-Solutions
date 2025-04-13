// Last updated: 13/04/2025, 14:06:14
class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> first = helper(s);
        Stack<Character> second = helper(t);

        while(!first.isEmpty() && !second.isEmpty()){
            if(first.pop()!=second.pop()){
                return false;
            }
        }

        if(!first.isEmpty() || !second.isEmpty()){
            return false;
        }

        return true;
    }

    public Stack<Character> helper(String s){
        Stack<Character> stack = new Stack<>();

        for(char ch : s.toCharArray()){
            if(ch=='#'){
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }
            else{
                stack.add(ch);
            }
        }

        return stack;
    }
}