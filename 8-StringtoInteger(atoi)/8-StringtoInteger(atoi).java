// Last updated: 18/04/2025, 22:09:49
class Solution {
    public int myAtoi(String s) {
        
        String trimmedString = s.stripLeading();

        boolean isNegative = false;

        if(trimmedString.length()>0 && trimmedString.charAt(0)=='-'){
            isNegative = true;
            trimmedString = trimmedString.substring(1,trimmedString.length());
        }
        else if(trimmedString.length()>0 && trimmedString.charAt(0)=='+'){
            trimmedString = trimmedString.substring(1,trimmedString.length());
        }

        String trimmedZeros = trimmedString.replaceFirst("^0+(?!$)", "");

        trimmedZeros = trimTillNonDigit(trimmedZeros);

        int result = 0;

        if(trimmedZeros.isEmpty()){
            return result;
        }

        String maxInt = String.valueOf(Integer.MAX_VALUE);

        String minInt = String.valueOf(Integer.MIN_VALUE);

        minInt = minInt.substring(1,minInt.length());

        if(trimmedZeros.length()>maxInt.length()){
            if(isNegative){
                return Integer.MIN_VALUE;
            }

            return Integer.MAX_VALUE;
        }

        if(trimmedZeros.length()==maxInt.length()){
            if(isNegative && trimmedZeros.compareTo(minInt)>0){
                return Integer.MIN_VALUE;
            }

            if(!isNegative && trimmedZeros.compareTo(maxInt)>0){
                return Integer.MAX_VALUE;
            }
        }

        if(isNegative){
            trimmedZeros = "-" + trimmedZeros; 
        }

        return Integer.parseInt(trimmedZeros);

    }

    public String trimTillNonDigit(String str){
        StringBuilder sb = new StringBuilder();

        for(Character ch : str.toCharArray()){
            if(Character.isDigit(ch)){
                sb.append(ch);
            }
            else{
                break;
            }
        }

        return sb.toString();
    }
}