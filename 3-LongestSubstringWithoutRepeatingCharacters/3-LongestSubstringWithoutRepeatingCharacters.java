// Last updated: 08/04/2025, 14:55:41
class Solution {
    public int lengthOfLongestSubstring(String str) {
        int start=0;
        int end=0;

        HashSet<Character> set = new HashSet<>();

        int max=0;

        while(start<=end && end<str.length()){
            if(!set.contains(str.charAt(end))){
                set.add(str.charAt(end));
                max=Math.max(max,end-start+1);
                end++;
            }
            else{
                set.remove(str.charAt(start));
                start++;
            }
        }

        return max;
    }
}