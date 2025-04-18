// Last updated: 17/04/2025, 22:50:01
class Solution {
    public int numTeams(int[] rating) {
        int[] dp = new int[rating.length];

        int count = 0;

        for(int i=1;i<dp.length;i++){
            for(int j=0;j<i;j++){
                if(rating[j]<rating[i]){
                    dp[i]=dp[i]+1;
                }
            }
        }

        int[] dp2 = new int[rating.length];



        for(int i=2;i<dp2.length;i++){
            for(int j=1;j<i;j++){
                if(rating[j]<rating[i]){
                    dp2[i]=dp2[i]+dp[j];
                }
            }

            count = count + dp2[i];
        }

        dp = new int[rating.length];

        for(int i=1;i<dp.length;i++){
            for(int j=0;j<i;j++){
                if(rating[j]>rating[i]){
                    dp[i]=dp[i]+1;
                }
            }
        }

        dp2 = new int[rating.length];



        for(int i=2;i<dp2.length;i++){
            for(int j=1;j<i;j++){
                if(rating[j]>rating[i]){
                    dp2[i]=dp2[i]+dp[j];
                }
            }

            count = count + dp2[i];
        }


        return count;

    }
}