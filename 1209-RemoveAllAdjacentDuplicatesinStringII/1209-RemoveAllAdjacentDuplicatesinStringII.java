// Last updated: 14/04/2025, 16:38:02
class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<Pair> stack = new Stack<>();

        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(stack.isEmpty()){
                stack.push(new Pair(c,1));
            }
            else{
                if(stack.peek().ch == s.charAt(i)){
                    stack.peek().idx++;
                    if(stack.peek().idx==k){
                        stack.pop();
                    }
                }
                else{
                    stack.push(new Pair(c,1));
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Pair p : stack) {
            for (int i = 0; i < p.idx; i++) {
                sb.append(p.ch);
            }
        }

        return sb.toString();

    }
}

class Pair{
    int idx;
    char ch;

    public Pair(char ch, int idx){
        this.idx=idx;
        this.ch=ch;
    }
}