class Solution {
    public int lengthOfLongestSubstring(String s) {
        int start=-1;
        int end=0;

        int max=0;

        HashSet<Character> set = new HashSet<>();
        while(start<end && end<s.length()){
            if(!set.contains(s.charAt(end))){
                max=Math.max(max,end-start);
                set.add(s.charAt(end));
                end++;
            }
            else{
                start++;
                set.remove(s.charAt(start));
            }
        }

        return max;
    }
}