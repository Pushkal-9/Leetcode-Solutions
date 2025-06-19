// Last updated: 19/06/2025, 13:44:34
class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<>();

        Set<Integer> list = new HashSet<>();

        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch =='('){
                stack.push(i);
            }
            else if(ch == ')'){
                if(!stack.isEmpty()){
                    stack.pop();
                }
                else{
                    list.add(i);
                }
            }
        }

        while(!stack.isEmpty()){
            list.add(stack.pop());
        }

        StringBuilder sb = new StringBuilder();

        for(int i=0;i<s.length();i++){
            if(!list.contains(i)){
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();
    }
}