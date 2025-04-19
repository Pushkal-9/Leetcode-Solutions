// Last updated: 19/04/2025, 18:26:53
class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<Pair<Character,Integer>> stack = new Stack<>();

        for(int i=0;i<s.length();i++){
            if(stack.isEmpty()){
                stack.push(new Pair<>(s.charAt(i),1));
            }
            else{
                if(stack.peek().getKey()==s.charAt(i)){
                    stack.push(new Pair<>(s.charAt(i),stack.peek().getValue()+1));
                }
                else{
                    stack.push(new Pair<>(s.charAt(i),1));
                }
            }

            if(!stack.isEmpty() && stack.peek().getValue()==k){
                char ch = stack.peek().getKey();

                while(!stack.isEmpty() && stack.peek().getKey()==ch){
                    stack.pop();
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for(Pair p : stack){
            sb.append(p.getKey());
        }

        return sb.toString();
    }
}