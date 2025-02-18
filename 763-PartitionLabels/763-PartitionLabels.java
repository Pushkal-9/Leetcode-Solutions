class Solution {
    public List<Integer> partitionLabels(String s) {

        HashMap<Character,Integer> last = new HashMap<>();

        for(int i=0;i<s.length();i++){
            last.put(s.charAt(i),i);
        }

        int start=0;
        int end = 0;

        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            end = Math.max(end, last.get(s.charAt(i))); 

            if (i == end) { 
                res.add(end - start + 1);
                start = i + 1;
            }
        }

        return res;
    }
}