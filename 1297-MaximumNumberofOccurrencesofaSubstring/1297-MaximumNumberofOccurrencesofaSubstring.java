// Last updated: 13/04/2025, 20:31:18
class Solution {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        Map<String, Integer> freqMap = new HashMap<>();
        Map<Character, Integer> charCount = new HashMap<>();
        
        int left = 0;
        int maxFreq = 0;

        // Initialize the first window
        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            charCount.put(ch, charCount.getOrDefault(ch, 0) + 1);
            
            // Maintain the window size of minSize
            if (right - left + 1 > minSize) {
                char toRemove = s.charAt(left);
                charCount.put(toRemove, charCount.get(toRemove) - 1);
                if (charCount.get(toRemove) == 0) {
                    charCount.remove(toRemove);
                }
                left++;
            }

            // When window size is exactly minSize
            if (right - left + 1 == minSize) {
                if (charCount.size() <= maxLetters) {
                    String sub = s.substring(left, right + 1);
                    int count = freqMap.getOrDefault(sub, 0) + 1;
                    freqMap.put(sub, count);
                    maxFreq = Math.max(maxFreq, count);
                }
            }
        }

        return maxFreq;
    }
}