// Last updated: 13/04/2025, 20:26:51
class Solution {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        int[] count = new int[26];

        HashMap<String,Integer> map = new HashMap<>();


        for(int size=minSize;size<=maxSize;size++){
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
                //System.out.println(s.substring(0,size));
            }

            for(int i=0;i<s.length()-size;i++){
                count[s.charAt(i)-'a']--;
                count[s.charAt(i+size)-'a']++;

                if(unique(count)<=maxLetters){
                    String str = s.substring(i+1,i+size+1);
                    //System.out.println(str);
                    map.put(str,map.getOrDefault(str,0)+1);
                }
            }
        }

        int max = 0;

        for(int i : map.values()){
            max=Math.max(i,max);
        }

        return max;
    }

    public int unique(int[] count){
        int u = 0;
        
        for(int i : count){
            if(i>0){
                u++;
            }
        }

        return u;
    }
}