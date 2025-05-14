// Last updated: 13/05/2025, 20:08:36
class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        StringBuilder sb = new StringBuilder();

        long num = (long)numerator;
        long den = (long)denominator;

        if(num * den < 0){
            sb.append("-");
        }
        
        num = Math.abs(num);
        den = Math.abs(den);

        sb.append(num/den);

        long rem = num % den;

        if(rem==0){
            return sb.toString();
        }

        sb.append(".");

        HashMap<Long,Integer> map = new HashMap<>();


        while(rem!=0 && !map.containsKey(rem)){
            map.put(rem,sb.length());
            rem=rem*10;
            sb.append(rem/den);
            rem = (rem % den);

        }

        if(rem!=0)
        {
            sb.insert(map.get(rem),"(");
            sb.append(")");
        }

        return sb.toString();
    }
}