// Last updated: 20/04/2025, 18:12:30
class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;

        int[] candy = new int[n];

        Arrays.fill(candy,1);

        for(int i=1 ;i<n; i++){
            if(ratings[i-1] < ratings[i]){

                candy[i] = candy[i-1] + 1;

            }
        }

        for(int i = n-2; i>=0; i--){

            if(ratings[i+1] < ratings[i]){

                candy[i] = Math.max(candy[i+1]+1, candy[i]);

            }
        }

        int total = Arrays.stream(candy).sum();

        return total;
    }
}