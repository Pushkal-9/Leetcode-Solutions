// Last updated: 20/04/2025, 18:06:07
class Solution {
    public int candy(int[] ratings) {
        int min = Integer.MAX_VALUE;
        int n = ratings.length;
        int[] res = new int[n];
        
        Arrays.fill(res,1);

        for(int i=0;i<n-1;i++){
            if(ratings[i]<ratings[i+1]){
                res[i+1]=res[i]+1;
            }
        }

        for(int i=n-1;i>0;i--){
            if(ratings[i]<ratings[i-1]){
                res[i-1]=Math.max(res[i-1],res[i]+1);
            }
        }

        int ans = 0;

        for(int i=0;i<n;i++){
            ans=ans+res[i];
            }

            return ans;
    }
} 