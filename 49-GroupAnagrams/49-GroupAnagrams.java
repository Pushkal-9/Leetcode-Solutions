// Last updated: 19/04/2025, 12:50:21
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

        Arrays.sort(chars);

        return String.valueOf(chars);
    }
}