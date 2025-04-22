// Last updated: 22/04/2025, 12:07:40
class Solution {
    public int shipWithinDays(int[] weights, int days) {

        int high = 0;

        int low = Integer.MIN_VALUE;

        for(int i=0;i<weights.length;i++){
            low = Math.max(low,weights[i]);
            high = high + weights[i];
        }


        while(low<=high){
            
            int mid = (high-low)/2 + low;

            int cal = calculateDays(weights,mid);

            //System.out.println(cal + " " + mid + " " + low + " " + high);

            if(cal<=days){
                 high = mid-1;
            }
            else if (cal>days){
                low = mid+1;
            }
        }

        return low;
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