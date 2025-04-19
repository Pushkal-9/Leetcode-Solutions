// Last updated: 19/04/2025, 01:18:14
class Solution {
    public String smallestString(String s) {
        int start = -1;

        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!='a'){
                start=i;
                break;
            }
        }

        if(start==-1){
            return s.substring(0,s.length()-1) + "z";
        }

        int end = -1;

        for(int i=start;i<s.length();i++){

            if(s.charAt(i)!='a'){
                end = i;
            }
            else{
                break;
            }
        }

        return s.substring(0,start) + buildSubString(start,end,s) + s.substring(end+1,s.length());
    }

    public String buildSubString(int start, int end, String s){
        String sub = s.substring(start,end+1);

        StringBuilder sb = new StringBuilder();

        for(char ch : sub.toCharArray()){
            sb.append(getPreviousChar(ch));
        }

        return sb.toString();
    }

    public char getPreviousChar(char ch){
        return ch == 'a' ? 'z' : (char)(ch - 1);
    }
}