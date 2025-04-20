// Last updated: 19/04/2025, 23:35:05
class Solution {
    public String removeOccurrences(String s, String part) {
        Stack<Character> stack = new Stack<>();

        for(int i=0; i<s.length(); i++){

            stack.push(s.charAt(i));

            if(s.charAt(i) == part.charAt(part.length() - 1)){
                if(matches(stack, part)){
                    for(int j=0; j<part.length(); j++){
                        char ch = stack.pop();
                        //System.out.println(ch);
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for(char ch : stack){
            sb.append(ch);
        }

        return sb.toString();
    }

    public boolean matches(Stack<Character> stack, String part){
        if(part.length()>stack.size()){
            return false;
        }

        Stack<Character> temp = new Stack<>();

        temp.addAll(stack);

        int len = part.length();

        while(len>0){
            char ch = temp.pop();
            //System.out.println(ch + " " + part.charAt(len-1));
            if(ch != part.charAt(len-1)){
                return false;
            }

            len--;
        }

        //System.out.println(len);

        return true;
    }
}