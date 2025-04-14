// Last updated: 14/04/2025, 16:33:17
class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<Pair> stack = new Stack<>();

        for(int i=0;i<s.length();i++){
            if(stack.isEmpty()){
                stack.push(new Pair(s.charAt(i),1));
            }
            else{
                if(stack.peek().ch == s.charAt(i)){
                    if(stack.peek().idx==k-1){
                        int count = k-1;
                        while(count>0){
                            stack.pop();
                            count--;
                        }
                    }
                    else{
                        stack.push(new Pair(s.charAt(i),stack.peek().idx+1));
                    }
                }
                else{
                    stack.push(new Pair(s.charAt(i),1));
                }
            }
        }

        String result = "";

        while(!stack.isEmpty()){
            result = String.valueOf(stack.pop().ch) + result;
        }

        return result;

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