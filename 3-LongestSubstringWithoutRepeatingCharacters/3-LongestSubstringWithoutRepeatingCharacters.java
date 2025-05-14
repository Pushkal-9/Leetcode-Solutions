// Last updated: 13/05/2025, 20:12:52
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int start = 0, end = 0;

        HashSet<Character> set = new HashSet<>();

        int max = 0;

        while(end<s.length()){

            if(!set.contains(s.charAt(end))){
                max = Math.max(max,end-start+1);
                set.add(s.charAt(end));
                end++;
            }
            else{
                set.remove(s.charAt(start));
                start++;
            }
        }

        return max;
    }
}