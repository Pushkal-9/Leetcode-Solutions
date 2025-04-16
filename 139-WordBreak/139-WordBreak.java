// Last updated: 15/04/2025, 19:48:49
class Solution {
    HashSet<String> set;
    Boolean[] mem;
    public boolean wordBreak(String s, List<String> wordDict) {
        set = new HashSet<>();
        mem = new Boolean[s.length()+1];

        for(String word : wordDict){
            set.add(word);
        }

        return isValid(s,0);
    }

    public boolean isValid(String s, int start){

        if(start==s.length()){
            return true;
        }

        if(mem[start]!=null){
            return mem[start];
        }

        for(int i=start+1;i<=s.length();i++){
            if(set.contains(s.substring(start,i)) && isValid(s,i)){
                mem[i]=true;
                return mem[i];
            }
        }

        mem[start] =false;

        return mem[start];
    }
}