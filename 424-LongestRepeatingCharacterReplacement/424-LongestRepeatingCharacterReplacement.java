class Solution {
    public int characterReplacement(String s, int k) {
        int max = 0; 
        int n = s.length();

        for (int i = 0; i < 26; i++) {
            char ch = (char) ('A' + i);
            int start = 0, end = 0, cur = 0;

            while (end < n) {
                if (s.charAt(end) != ch) {
                    cur++;
                }
                end++;

                while (cur > k) { 
                    if (s.charAt(start) != ch) {
                        cur--;
                    }
                    start++;
                }

                max = Math.max(max, end - start);
            }
        }

        return max;
    }
}
