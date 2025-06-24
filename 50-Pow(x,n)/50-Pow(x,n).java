// Last updated: 23/06/2025, 22:33:44
class Solution {
    public double myPow(double x, int n) {
        if(n == 0 || x == 1){
            return 1;
        }

        if(x == 0){
            return 0;
        }
        if(n < 0){
            return 1/x * myPow(1/x, -1 * (n+1));
        }

        if(n == 1){
            return x;
        }

        double subPower = myPow(x,n/2);

        if(n%2 == 0){
            return subPower * subPower;
        }

        return x * subPower * subPower;
    }
}