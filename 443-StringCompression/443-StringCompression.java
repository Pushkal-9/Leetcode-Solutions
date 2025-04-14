// Last updated: 14/04/2025, 15:19:05
class Solution {
    public int compress(char[] chars) {
        StringBuilder sb = new StringBuilder();
        int i=0;
        int j=0;
        while(i<chars.length){
            int count = 0;

            char current = chars[i];

            while(i<chars.length && current==chars[i]){
                count++;
                i++;
            }

            chars[j]=current;
            j++;
            if(count!=1){
                String str = String.valueOf(count);
                for(char ch : str.toCharArray()){
                    chars[j]=ch;
                    j++;
                }
            }
        }

        return j;
    }
}