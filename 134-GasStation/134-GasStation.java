class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int curgas = 0;
        int curcost = 0;

        int totalGas = 0;
        int totalCost = 0;

        int cur = 0;

        for(int i=0;i<gas.length;i++){
            curgas = curgas + gas[i];
            totalGas += gas[i];
            totalCost+= cost[i];

            curcost = curcost + cost[i];

            if(curcost>curgas){
                cur = i+1;
                curcost=0;
                curgas=0;
            }
        }

        if(totalGas>=totalCost){
            return cur;
        }

        return -1;
    }
}