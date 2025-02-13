class Solution {
    public int numDecodings(String s) {
        int[]dp=new int[s.length()+1];
        dp[0]=1;
        dp[1]=1;
        
        if(s.charAt(0)=='0'){
            return 0;
        }
        for(int i=2;i<s.length()+1;i++){
            if(Integer.parseInt(s.substring(i-1,i))==0){
                if(Integer.parseInt(s.substring(i-2,i))>26 || s.substring(i-2,i).equals("00")){
                    return 0;}
                dp[i]=dp[i-2];
            }
            else if(Integer.parseInt(s.substring(i-2,i))>26 || Integer.parseInt(s.substring(i-2,i-1))==0){
                dp[i]=dp[i-1];
            }
            else{
                dp[i]=dp[i-1]+dp[i-2];
            }
        }
        
//         String str="pushkal";
            
//             System.out.println(str.substring(,3));
        
        return dp[s.length()];
    }
}