// Last updated: 13/04/2025, 20:35:39
class Solution {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        int[] count = new int[26];
        HashMap<String, Integer> map = new HashMap<>();

        // Only loop for minSize (as per optimal logic)
        int size = minSize;
        int k = 0;

        // Initial window
        for (int i = 0; i < size; i++) {
            char ch = s.charAt(i);
            if (count[ch - 'a'] == 0) k++; // new unique char
            count[ch - 'a']++;
        }

        if (k <= maxLetters) {
            map.put(s.substring(0, size), 1);
        }

        // Sliding window
        for (int i = 0; i < s.length() - size; i++) {
            char out = s.charAt(i);
            char in = s.charAt(i + size);

            count[out - 'a']--;
            if (count[out - 'a'] == 0) k--; // one unique char removed

            if (count[in - 'a'] == 0) k++; // new unique char coming in
            count[in - 'a']++;

            if (k <= maxLetters) {
                String str = s.substring(i + 1, i + size + 1);
                map.put(str, map.getOrDefault(str, 0) + 1);
            }
        }

        int max = 0;
        for (int val : map.values()) {
            max = Math.max(max, val);
        }

        return max;
    }
}
