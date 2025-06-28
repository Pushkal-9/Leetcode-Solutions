// Last updated: 28/06/2025, 17:39:01
class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> map = new HashMap<>();

        for(String str : strings){
            String hashKey = getHashKey(str);

            if(!map.containsKey(hashKey)){
                map.put(hashKey, new ArrayList<>());
            }

            map.get(hashKey).add(str);
        }

        List<List<String>> result = new ArrayList<>();

        for(String key : map.keySet()){
            result.add(map.get(key));
        }

        return result;
    }

    public String getHashKey(String str){
        StringBuilder sb = new StringBuilder();
        int shift = 26 - str.charAt(0) - 'a';
        for( char ch : str.toCharArray()){
            char shifted = shiftedChar(ch,shift);
            sb.append(shifted);
        }
        return sb.toString();
    }

    public char shiftedChar(char ch, int shift) {
        return (char) ((ch - 'a' + shift) % 26 + 'a');
    }

}