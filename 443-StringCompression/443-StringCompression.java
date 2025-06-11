// Last updated: 11/06/2025, 15:13:52
class Solution {
    public int compress(char[] chars) {
        int index = 0;
        int count = 0;

        int pointer = 0;

        while(index<chars.length){
            char cur = chars[index];
            count = 0;
            while(index<chars.length && cur == chars[index]){
                count++;
                index++;
            }

            chars[pointer] = cur;
            pointer++;

            if(count==1){
                continue;
            }
            
            String str = String.valueOf(count);

            for(int i=0;i<str.length();i++){

                chars[pointer] = str.charAt(i);
                pointer++;
            }
        }

        return pointer;
    }
}