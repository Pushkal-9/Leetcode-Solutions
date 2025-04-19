// Last updated: 19/04/2025, 12:14:43
class Solution {
    public int compress(char[] chars) {
        List<String> list = new ArrayList<>();

        int pointer = 0;

        int result = 0;

        int i=0;

        int index = 0;

        while(i<chars.length){
            
            char ch = chars[i];
            int count = 0;

            while(i<chars.length && ch==chars[i]){
                count++;
                i++;
            }

            chars[index] =  ch;
            index++;

            if(count==1){
                continue;
            }

            String s = String.valueOf(count);

            for(char c : s.toCharArray()){
                chars[index] = c;
                index++;
            }
            
        }

        return index;
    }
}