// Last updated: 28/06/2025, 16:06:01
class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Integer> stack = new Stack<>();

        int count = 0;

        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);

            if(!stack.isEmpty()){
                if(ch == ')'){
                    stack.pop();
                }
                else{
                    stack.push(i);
                }
            }
            else{
                if(ch == ')'){
                    count++;
                }
                else{
                    stack.push(i);
                }
            }
        }

        return count + stack.size();
    }
}