// Last updated: 11/04/2025, 22:30:30
class Solution {
    public int[][] highFive(int[][] items) {
        HashMap<Integer,PriorityQueue<Integer>> map = new HashMap<>();

        for(int[] pair : items){

            int id = pair[0];
            int score = pair[1];
            if(map.containsKey(id)){
                if(map.get(id).size()<5){
                    map.get(id).add(score);
                }
                else if(map.get(id).peek()<score){
                    map.get(id).poll();
                    map.get(id).add(score);
                }
            }
            else{
                map.put(id, new PriorityQueue<>());
                map.get(id).add(score);
            }
        }

        int[][] averages = new int[map.size()][2];

        int index = 0;

        for(int id : map.keySet()){
            PriorityQueue<Integer> pq = map.get(id);
            int sum = 0;

            while(!pq.isEmpty()){
                sum=sum+pq.poll();
            }

            averages[index][0]=id;
            averages[index][1]=sum/5;

            index++;
        }

        Arrays.sort(averages, (a,b) -> a[0]-b[0]);

        return averages;
    }
}