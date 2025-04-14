// Last updated: 13/04/2025, 22:38:34
class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;

        int[] right = new int[prices.length];

        right[prices.length-1]=0;

        for(int i=right.length-2; i>=0 ;i--){
            right[i]=Math.max(right[i+1],prices[i+1]);
        }

        for(int i=0;i<prices.length;i++){
            max=Math.max(max,right[i]-prices[i]);
        }

        return max;
    }
}