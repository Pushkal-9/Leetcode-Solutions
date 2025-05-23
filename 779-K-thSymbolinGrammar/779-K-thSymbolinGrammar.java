// Last updated: 19/04/2025, 18:01:01
class Solution {
    public int kthGrammar(int n, int k) {
        if(n==1){
            return 0;
        }

        int total = (int) Math.pow(2,n-1);

        int mid = total/2;

        if(k<=mid){
            return kthGrammar(n-1,k);
        }

        return 1 - kthGrammar(n-1,k-mid);
    }
}