// Last updated: 19/04/2025, 18:05:32
class Solution {
    public String smallestString(String s) {
        int start = -1;

        StringBuilder sb = new StringBuilder();

        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!='a'){
                start=i;
                break;
            }
            sb.append(s.charAt(i));
        }

        if(start==-1){
            return s.substring(0,s.length()-1) + "z";
        }

        int end = -1;

        for(int i=start;i<s.length();i++){

            if(s.charAt(i)=='a'){
                break;
            }
            
            end = i;
            sb.append(getPreviousChar(s.charAt(i)));
        }

        return sb.append(s.substring(end+1,s.length())).toString();
    }

    public char getPreviousChar(char ch){
        return ch == 'a' ? 'z' : (char)(ch - 1);
    }
}