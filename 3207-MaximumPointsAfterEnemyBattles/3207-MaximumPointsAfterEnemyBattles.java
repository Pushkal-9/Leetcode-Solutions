// Last updated: 05/05/2025, 19:54:29
class Solution {
    public long maximumPoints(int[] enemyEnergies, int currentEnergy) {
        Arrays.sort(enemyEnergies);

        int start = 0;
        int end = enemyEnergies.length-1;

        long count = 0;

        while(start<=end){
            if(enemyEnergies[start]<=currentEnergy){
                count +=  currentEnergy/enemyEnergies[start];
                currentEnergy = currentEnergy%enemyEnergies[start];
            }
            else if(count>0){
                currentEnergy = currentEnergy + enemyEnergies[end];
                end--;
            }
            else{
                break;
            }
        }

        return count;
    }
}