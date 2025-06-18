// Last updated: 18/06/2025, 16:34:07
class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low = max(weights);

        int high = Integer.MAX_VALUE;

        System.out.println(low);

        while(low<=high){

            int mid = (high-low)/2 + low;

            int cur = calculateDays(weights,mid);

            if(cur <= days){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }

        return low;
    }

    public int max(int[] nums){
        int max =Integer.MIN_VALUE;

        for(int i : nums){
            max = Math.max(max,i);
        }

        return max;
    }

   public int calculateDays(int[] weights, int capacity){
        
        int sum = 0;

        int res = 0;

        for(int i=0;i<weights.length;i++){

            sum = sum + weights[i];

            if(sum==capacity){
                res++;
                sum=0;
            }
            else if(sum>capacity){
                res++;
                sum = weights[i];
            }
        }

        if(sum!=0){
            res++;
        }

        return res;
    }
}