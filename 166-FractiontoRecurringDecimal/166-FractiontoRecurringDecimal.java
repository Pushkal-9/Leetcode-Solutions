// Last updated: 11/04/2025, 23:41:04
class Solution {
    public String fractionToDecimal(int num, int den) {
        if (num == 0) return "0";

        StringBuilder sb = new StringBuilder();

        long numerator = (long) num;
        long denominator = (long) den;

        // Append negative sign if needed
        if (numerator * denominator < 0) {
            sb.append("-");
        }

        // Work with absolute values to avoid overflow issues
        numerator = Math.abs(numerator);
        denominator = Math.abs(denominator);

        // Append the integral part
        sb.append(numerator / denominator);

        long remainder = numerator % denominator;
        if (remainder == 0) return sb.toString();

        // Prepare for fractional part
        sb.append(".");
        Map<Long, Integer> map = new HashMap<>();

        // Long division with cycle detection
        while (remainder != 0 && !map.containsKey(remainder)) {
            map.put(remainder, sb.length());
            remainder *= 10;
            sb.append(remainder / denominator);
            remainder %= denominator;
        }

        if (remainder != 0) {
            int index = map.get(remainder);
            sb.insert(index, "(");
            sb.append(")");
        }

        return sb.toString();
    }
}