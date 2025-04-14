// Last updated: 13/04/2025, 20:38:19
class Solution {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        int[] count = new int[26];

        HashMap<String,Integer> map = new HashMap<>();
        int size = minSize;

            count = new int[26];
            int k = 0;
            for(int i=0;i<size;i++){
                char ch = s.charAt(i);
                count[ch-'a']++;
            }

            for(int i=0;i<26;i++){
                if(count[i]>0){
                    k++;
                }
            }

            if(k<=maxLetters){
                map.put(s.substring(0,size),1);
            }

            for(int i=0;i<s.length()-size;i++){
                count[s.charAt(i)-'a']--;


                if(count[s.charAt(i)-'a']==0){
                    k--;
                }

                if(count[s.charAt(i+size)-'a']==0){
                    k++;
                }
                count[s.charAt(i+size)-'a']++;


                if(k<=maxLetters){
                    String str = s.substring(i+1,i+size+1);
                    map.put(str,map.getOrDefault(str,0)+1);
                }
            }

        int max = 0;

        for(int i : map.values()){
            max=Math.max(i,max);
        }

        return max;
    }
}