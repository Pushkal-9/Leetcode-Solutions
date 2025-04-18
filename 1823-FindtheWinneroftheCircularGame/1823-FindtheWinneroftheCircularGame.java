// Last updated: 18/04/2025, 18:27:27
class Solution {
    public int findTheWinner(int n, int k) {
        List<Integer> list = new ArrayList<>();

        for(int i=1;i<=n;i++){
            list.add(i);
        }

        int startIndex = 0;

        while(list.size()>1){
            int removalIndex = (startIndex + k - 1) % list.size();
            list.remove(removalIndex);

            startIndex = removalIndex;
        }

        return list.get(0);
    }
}