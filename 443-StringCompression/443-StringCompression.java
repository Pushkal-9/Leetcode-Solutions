// Last updated: 14/04/2025, 15:20:59
class Solution {
    public int compress(char[] chars) {
        int i = 0, j = 0;

        while (i < chars.length) {
            char current = chars[i];
            int count = 0;

            while (i < chars.length && chars[i] == current) {
                count++;
                i++;
            }

            chars[j++] = current;

            if (count > 1) {
                int start = j;
                while (count > 0) {
                    chars[j++] = (char) ('0' + count % 10);
                    count /= 10;
                }
                reverse(chars, start, j - 1);
            }
        }

        return j;
    }

    private void reverse(char[] chars, int left, int right) {
        while (left < right) {
            char temp = chars[left];
            chars[left++] = chars[right];
            chars[right--] = temp;
        }
    }
}
