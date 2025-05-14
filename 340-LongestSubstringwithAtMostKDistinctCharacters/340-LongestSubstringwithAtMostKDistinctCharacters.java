// Last updated: 14/05/2025, 17:56:43
class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {

        if(k==0){
            return 0;
        }
        HashMap<Character, Integer> map = new HashMap<>();

        int start = 0;
        int end = 0;

        int max = 0;

        while(end<s.length()){
            if(map.containsKey(s.charAt(end)) || map.size()<k){
                max = Math.max(max, end-start+1);
                map.put(s.charAt(end), map.getOrDefault(s.charAt(end),0)+1);
                end++;
            }
            else{
                map.put(s.charAt(start), map.get(s.charAt(start))-1);

                if(map.get(s.charAt(start))==0){
                    map.remove(s.charAt(start));
                }

                start++;
            }
        }

        return max;
    }
}