class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map = new HashMap<>();

        for(int i=0;i<strs.length;i++){
            String sorted = sortedString(strs[i]);
            if(map.containsKey(sorted)){
                map.get(sorted).add(strs[i]);
            }
            else{
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                map.put(sorted,list);
            }
        }

        return new ArrayList<>(map.values());
    }

    private String sortedString(String str){
        char[] charArray = str.toCharArray();

        Arrays.sort(charArray);

        return new String(charArray);
    }
}