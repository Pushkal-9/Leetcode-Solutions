class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character,Integer> map1 = new HashMap<>();
        HashMap<Character,Integer> map2 = new HashMap<>();

        if(s.length()!=t.length()){
            System.out.println("returning 1");
            return false;
        }

        for(int i=0;i<s.length();i++){
            map1.put(s.charAt(i),map1.getOrDefault(s.charAt(i),0)+1);
            map2.put(t.charAt(i),map2.getOrDefault(t.charAt(i),0)+1);
        }

        if(map1.size()!=map2.size()){
            System.out.println("returning 2");
            return false;
        }

        for(Character ch : map1.keySet()){
            if(!map1.get(ch).equals(map2.get(ch))){
                System.out.println("returning 3 :" + ch + " " + map1.get(ch) + " " + map2.get(ch));
                return false;
            }
        }

        return true;
    }
}