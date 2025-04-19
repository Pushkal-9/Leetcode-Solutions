// Last updated: 19/04/2025, 15:43:05
class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();

        int max = 0;

        for(int i=0;i<26;i++){
            char ch = (char)('A' + i);
            int end=0, start=0;
            int count=0;

            while(end<s.length()){
                if(s.charAt(end)!=ch){
                    count++;
                }

                while(count>k){
                    if(s.charAt(start)!=ch){
                        count--;
                    }
                    start++;
                }

                max=Math.max(end-start+1,max);

                end++;
            }
        }

        return max;
    }
}