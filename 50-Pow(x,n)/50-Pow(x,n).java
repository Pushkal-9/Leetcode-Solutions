// Last updated: 23/06/2025, 22:32:46
class Solution {
    public double myPow(double x, int n) {
        if(x==1){
            return 1;
        }
        if(n<0){
            return 1/x * myPow(1/x, -(n + 1));
        }
        if(n==0){
            return 1;
        }
        if(n==1){
            return x;
        }

        int half = n/2;

        double sub = myPow(x, half);

        double halfPow = sub*sub;

        if(n%2==0){
            return halfPow;
        }

        return halfPow * x;
    }
}