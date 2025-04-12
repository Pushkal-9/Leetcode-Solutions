// Last updated: 11/04/2025, 22:05:28
class Solution {
    public int firstUniqChar(String s) {
        HashSet<Character> nonRepeating = new HashSet<>();
        HashSet<Character> repeating = new HashSet<>();

        for(char ch : s.toCharArray()){
            if(!repeating.contains(ch)){
                if(nonRepeating.contains(ch)){
                    nonRepeating.remove(ch);
                    repeating.add(ch);
                }
                else{
                    nonRepeating.add(ch);
                }
            }
        }

        for(int i=0;i<s.length();i++){
            if(nonRepeating.contains(s.charAt(i))){
                return i;
            }
        }

        return -1;
    }
}