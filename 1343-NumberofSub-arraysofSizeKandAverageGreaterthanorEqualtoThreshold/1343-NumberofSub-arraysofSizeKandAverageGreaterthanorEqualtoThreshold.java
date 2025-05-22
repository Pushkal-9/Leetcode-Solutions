// Last updated: 22/05/2025, 13:31:24
class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int noOfSubArrays = 0;

        int currentSum = 0;

        for(int i=0;i<k;i++){
            currentSum = currentSum + arr[i];
        }

        double average = (double)currentSum/k;

        if(average>=threshold){
            noOfSubArrays++;
        }

        for(int i=k;i<arr.length;i++){
            currentSum = currentSum + arr[i];
            currentSum = currentSum - arr[i-k];

            average = (double)currentSum/k;

            if(average>=threshold){
                noOfSubArrays++;
            }

        }

        return noOfSubArrays;
    }
}