class Solution {
    public String reorganizeString(String s) {
        int[] freq = new int[26];

        for(int i=0;i<s.length();i++){
            freq[s.charAt(i)-'a']= freq[s.charAt(i)-'a'] + 1;
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> b.count-a.count);

        for(int i=0;i<26;i++){
            if(freq[i]!=0){
                pq.add(new Pair(freq[i],(char)('a'+i)));
            }
        }

        List<String> list = new ArrayList<>();

        Pair prev = null;

        String res = "";

        while(!pq.isEmpty()){
            Pair cur = pq.poll();

            res = res + String.valueOf(cur.ch);

            if(prev!=null){
                pq.add(prev);
            }

            cur.count--;

            if(cur.count!=0){
                prev=cur;
            }
            else{
                prev=null;
            }
        }

        if(prev!=null && prev.count!=0){
            return "";
        }

        return res;

        // if(freqList.size()<2){
        //     return "";
        // }

        // if(freqList.get(0).count-freqList.get(1).count>1){
        //     return "";
        // }

        // for(int i=0;i<freqList.size();i++){
        //     Pair p = freqList.get(i);
        //     for(int j=0;j<p.count;j++){
        //         if(list.size()<=j){
        //             String str = String.valueOf(p.ch);
        //             list.add(str);
        //         }
        //         else{
        //             String str = list.get(j) + String.valueOf(p.ch);
        //             list.set(j,str);
        //         }
        //     }
        // }


        // String res ="";

        // for(String st : list){
        //     res=res+st;
        // }

    }
}

class Pair{
    int count;
    char ch;

    public Pair(int count, char ch){
        this.count=count;
        this.ch=ch;
    }
}