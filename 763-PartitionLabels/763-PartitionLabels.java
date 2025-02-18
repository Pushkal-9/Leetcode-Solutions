class Solution {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character,Integer> first = new HashMap<>();
        HashMap<Character,Integer> last = new HashMap<>();

        for(int i=0;i<s.length();i++){
            if(!first.containsKey(s.charAt(i))){
                first.put(s.charAt(i),i);
                last.put(s.charAt(i),i);
            }
            else{
                last.put(s.charAt(i),i);
            }
        }

        List<Point> list = new ArrayList<>();

        for(char ch : first.keySet()){
            list.add(new Point(first.get(ch),true));
        }

        for(char ch : last.keySet()){
            list.add(new Point(last.get(ch),false));
        }

        Collections.sort(list, (a,b) -> {
            if(a.value!=b.value){
                return a.value-b.value;
            }

            return Boolean.compare(b.isStart,a.isStart);
        });

        int start=0;
        int end = 0;

        int count = 0;

        List<Integer> res = new ArrayList<>();


        for(Point point : list){
            if(point.isStart){
                if(count==0)
                    start=point.value;
                count++;
            }
            else{
                count--;
                if(count==0){
                    end=point.value;
                    res.add(end-start+1);
                }
            }
        }

        return res;
    }
}

class Point{
    int value;
    boolean isStart;

    public Point(int value, boolean isStart){
        this.value=value;
        this.isStart=isStart;
    }
}