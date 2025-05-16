// Last updated: 15/05/2025, 23:01:29
class Solution {
    public int characterReplacement(String s, int k) {
        int max = 0;

        for(int i=0;i<26;i++){
            char ch = (char)('A' + i);

            int start=0;
            int end = 0;

            int count = 0;

            while(end<s.length()){
                if(s.charAt(end)==ch){
                    max = Math.max(end-start+1,max);
                    end++;
                }
                else{
                    if(count<k){
                        count++;
                        max = Math.max(end-start+1, max);
                        end++;       
                    }
                    else{
                        if(s.charAt(start)!=ch){
                            count--;
                        }
                        start++;
                    }
                }
            }
        }

        return max;
    }
}