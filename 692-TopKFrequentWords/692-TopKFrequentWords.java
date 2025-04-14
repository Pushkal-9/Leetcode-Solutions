// Last updated: 13/04/2025, 19:53:24
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();

        for(String word : words){
            map.put(word,map.getOrDefault(word,0)+1);
        }

        List<Pair> list = new ArrayList<>();

        for(String word : map.keySet()){
            list.add(new Pair(word, map.get(word)));
        }

        Collections.sort(list, (a,b)-> {
            if(a.frequency!=b.frequency){
                return b.frequency-a.frequency;
            }

            return a.word.compareTo(b.word);
        });

        List<String> result = new ArrayList<>();


        for(int i=0;i<k;i++){
            result.add(list.get(i).word);
        }

        return result;
        
    }
}

class Pair{
    String word;
    int frequency;

    public Pair(String word, int frequency){
        this.word=word;
        this.frequency=frequency;
    }
}