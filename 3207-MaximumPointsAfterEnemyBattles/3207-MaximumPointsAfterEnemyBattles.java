// Last updated: 05/05/2025, 19:56:27
class Solution {
    public long maximumPoints(int[] enemyEnergies, int currentEnergy) {
        Arrays.sort(enemyEnergies);

        int end = enemyEnergies.length-1;

        int start = enemyEnergies[0];

        long count = 0;

        while(end>=0){
            if(start<=currentEnergy){
                count +=  currentEnergy/start;
                currentEnergy = currentEnergy%start;
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