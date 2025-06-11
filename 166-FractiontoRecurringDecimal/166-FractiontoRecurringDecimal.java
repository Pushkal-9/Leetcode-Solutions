// Last updated: 11/06/2025, 14:42:49
class Solution {
    public String fractionToDecimal(int num, int den) {
        StringBuilder sb = new StringBuilder();

        long numerator = (long)num;
        long denominator = (long)den;

        if(numerator * denominator < 0){
            sb.append("-");
            numerator = Math.abs(numerator);
            denominator = Math.abs(denominator);
        }

        long reminder = numerator % denominator;
        long div = numerator / denominator;

        sb.append(div);

        if(reminder == 0){
            return sb.toString();
        }

        sb.append(".");

        HashMap<Long, Integer> map = new HashMap<>();
        int index = sb.length();

        while(reminder!= 0 && !map.containsKey(reminder)){
            map.put(reminder, index);
            //System.out.println(reminder + " " + index);
            index++;
            reminder = reminder * 10;
            div = reminder/denominator;
            reminder = reminder%denominator;
            sb.append(div);
        }

        if(reminder == 0){
            return sb.toString();
        }      

        sb.insert(map.get(reminder),"(");
        sb.append(')');

        return sb.toString();
    }
}