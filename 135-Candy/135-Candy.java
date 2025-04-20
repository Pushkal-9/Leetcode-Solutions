// Last updated: 20/04/2025, 18:00:36
class Solution {
    public int candy(int[] ratings) {
        int min = Integer.MAX_VALUE;
        int n = ratings.length;
        int[] res = new int[n];

        if(n==1){
            return 1;
        }
        //Arrays.fill(res,1);
        for(int i=1;i<n-1;i++){
            if(ratings[i-1]>=ratings[i] && ratings[i+1]>=ratings[i]){
                res[i]=1;
            }
        }

        if(ratings[0]<=ratings[1]){
            res[0]=1;
        }
        if(ratings[n-1]<=ratings[n-2]){
            res[n-1]=1;
        }

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