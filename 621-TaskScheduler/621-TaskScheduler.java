class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character,Integer> map = new HashMap<>();

        for(char ch : tasks){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);

        for(char ch : map.keySet()){
            pq.add(map.get(ch));
            //System.out.println(ch + " " + map.get(ch));
        }

        int max = pq.poll();

        int total = (max-1)*n;

        while(!pq.isEmpty()){
            int current = pq.poll();

            if(current==max){
                total = total - (current-1);
            }
            else{
                total = total - current;
            }
        }

        if(total<0){
            return tasks.length;
        }

        return total + tasks.length;
    }
}