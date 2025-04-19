// Last updated: 19/04/2025, 13:21:18
class Solution {
    public int numDecodings(String s) {
        int[] dp = new int[s.length()+1];

        dp[0]=1;

        if(s.charAt(0)=='0'){
            return 0;
        }

        dp[1]=1;

        for(int i=1;i<s.length();i++){
            char cur = s.charAt(i);
            char prev = s.charAt(i-1);

            if(cur=='0' && prev!='1' && prev!='2'){
                return 0;
            }

            if(cur!='0'){
                dp[i+1]=dp[i];
            }

            if(prev=='1'){
                dp[i+1] +=dp[i-1];
            }
            else if(prev=='2' && (cur>='0' && cur<='6')){
                dp[i+1] +=dp[i-1];
            }
        }

        return dp[s.length()];
    }
}