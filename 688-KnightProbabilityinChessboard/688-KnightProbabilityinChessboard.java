// Last updated: 15/05/2025, 23:42:45
class Solution {
    int out=0;
    int in=0;
    public double knightProbability(int n, int k, int row, int column) {
        double x=backTrack(n,row,column,k);
        double y=(double)(Math.pow(8,k));
        
        if(k==0){
            return 1.00;
        }
        return x/y;
    }
    
    public double backTrack(int n,int r,int c,int l){
        
        int row[]={-2,-1,-2,-1,1,2,1,2};
        int col[]={-1,-2,1,2,-2,-1,2,1};
        double dp[][]=new double[n][n];
        double result = 1;
        dp[r][c]=1;
        for(int i=1;i<=l;i++){
            double temp[][]=new double[n][n];
            double nresult = 0;
            for(int j=0;j<n;j++){
                for(int k=0;k<n;k++){
                    if(dp[j][k]!=0){
                    for(int m=0;m<8;m++){
            if(isSafe(j+row[m],k+col[m],n)){
                temp[j+row[m]][k+col[m]]+=dp[j][k];
                nresult+=dp[j][k];
            }
        }}
                }
            }
            dp=temp;
            result = nresult;
        }
        
        return result;
    }
    
    public boolean isSafe(int r,int c,int n){
        return (r>=0 && c>=0 && r<n && c<n);
    }
}