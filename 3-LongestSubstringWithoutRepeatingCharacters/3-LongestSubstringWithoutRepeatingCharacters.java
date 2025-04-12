// Last updated: 11/04/2025, 23:47:46
class Solution {
    public int lengthOfLongestSubstring(String s) {

        int start = 0;
        int end = 0;

        int maxLength = 0;

        HashSet<Character> set = new HashSet<>();

        while(end<s.length()){

            if(!set.contains(s.charAt(end))){

                set.add(s.charAt(end));
                maxLength = Math.max(maxLength, end-start+1);
                end++;
            }
            else{
                set.remove(s.charAt(start));
                start++;
            }
        }

        return maxLength;
    }
}