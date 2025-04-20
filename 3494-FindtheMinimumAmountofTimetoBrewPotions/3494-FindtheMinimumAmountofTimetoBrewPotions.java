// Last updated: 20/04/2025, 00:32:38
class Solution {
    public long minTime(int[] skill, int[] mana) {
        int m = mana.length; 
        int n = skill.length; 

        long[] end = new long[n]; 
        int lastCompletionTime = 0;

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < m; i++) {
            long start = 0, maxDiff = 0; 

            for (int j = 0; j < n; j++) {
                
                maxDiff = Math.max(maxDiff, end[j] - start);
                start = start + skill[j] * mana[i];
                end[j] = start;
            }

            for(int j = 0; j <n; ++j) end[j] += maxDiff;
        }

        return end[n-1];
    }
}
