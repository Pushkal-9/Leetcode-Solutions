// Last updated: 19/04/2025, 01:19:16
class Solution {
    public String smallestString(String s) {
        char[] chars = s.toCharArray();
        int i = 0;

        // Skip leading 'a's
        while (i < chars.length && chars[i] == 'a') {
            i++;
        }

        // If all are 'a', change last char to 'z'
        if (i == chars.length) {
            chars[chars.length - 1] = 'z';
            return new String(chars);
        }

        // Start decrementing until next 'a' or end
        while (i < chars.length && chars[i] != 'a') {
            chars[i] = getPreviousChar(chars[i]);
            i++;
        }

        return new String(chars);
    }

    private char getPreviousChar(char ch) {
        return ch == 'a' ? 'z' : (char) (ch - 1);
    }
}
