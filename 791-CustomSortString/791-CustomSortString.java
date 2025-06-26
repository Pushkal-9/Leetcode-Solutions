// Last updated: 25/06/2025, 22:27:29
class Solution {
    public String customSortString(String order, String s) {
        int[] count = new int[26];

        for(char ch : s.toCharArray()){
            count[ch - 'a']++;
        }

        Set<Character> set = new HashSet<>();

        StringBuilder sb = new StringBuilder();

        for(char ch : order.toCharArray()){
            if(count[ch-'a']!=0){
                for(int i = 0; i< count[ch-'a'];i++){
                    sb.append(ch);
                }
                set.add(ch);
            }
        }

        for(char ch : s.toCharArray()){
            if(!set.contains(ch)){
                sb.append(ch);
            }
        }

        return sb.toString();
    }
}