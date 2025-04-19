// Last updated: 19/04/2025, 12:53:09
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String,List<String>> map = new HashMap<>();

        for(String str : strs){
            String sorted = sort(str);

            if(!map.containsKey(sorted)){
                map.put(sorted, new ArrayList<>());
            }

            map.get(sorted).add(str);
        }

        return new ArrayList<>(map.values());
    }

    public String sort(String str){
        char[] chars = str.toCharArray();

        int[] arr = new int[26];

        for(char ch : chars){
            arr[ch-'a']++;
        }

        StringBuilder sb = new StringBuilder();

        for(int i=0;i<26;i++){
            sb.append((char)('a' + i));
            sb.append(arr[i]);
        }

        return sb.toString();
    }
}