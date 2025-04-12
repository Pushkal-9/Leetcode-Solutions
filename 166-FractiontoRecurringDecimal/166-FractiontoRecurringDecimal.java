// Last updated: 11/04/2025, 23:41:16
class Solution {
    public String fractionToDecimal(int num, int den) {
        if(num==0){
            return "0";
        }

        StringBuilder sb = new StringBuilder();

        long numerator = (long) num;
        long denominator = (long) den;

        if(numerator * denominator < 0){
            sb.append("-");

        }

        numerator = Math.abs(numerator);
        denominator = Math.abs(denominator);

        sb.append(numerator/denominator);

        long remainder = numerator%denominator;

        if(remainder==0){
            return sb.toString();
        }

        sb.append(".");

        HashMap<Long,Integer> map = new HashMap<>();

        while(remainder!=0 && !map.containsKey(remainder)){
            map.put(remainder,sb.length());
            remainder = remainder * 10;
            sb.append(remainder/denominator);
            remainder = remainder % denominator;
        }

        if(remainder==0){
            return sb.toString();
        }

        return sb.substring(0,map.get(remainder)) + "(" + sb.substring(map.get(remainder)) + ")";

        
    }
}