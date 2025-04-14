// Last updated: 14/04/2025, 15:13:51
class Solution {
    public int compress(char[] chars) {
        StringBuilder sb = new StringBuilder();
        int i=0;
        while(i<chars.length){
            int count = 0;

            char current = chars[i];

            while(i<chars.length && current==chars[i]){
                count++;
                i++;
            }

            sb.append(current);
            if(count!=1)
                sb.append(count);
        }

        int len = sb.length();


        for(i=0;i<len;i++){
            chars[i]=sb.charAt(i);
        }

        return len;
    }
}