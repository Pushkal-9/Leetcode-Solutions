class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {

        List<Integer> list = new ArrayList<>();

        int n = fruits.length;

        int max=0;

        for(int i=0;i<n;i++){
            list.add(baskets[i]);
            max=Math.max(max,baskets[i]);
        }

        int count=0;
        for(int i=0;i<n;i++){
            if(fruits[i]>max){
                continue;
            }
            for(int j=0;j<list.size();j++){
                if(fruits[i]<=list.get(j)){
                    list.remove(j);
                    count++;
                    break;
                }
            }
        }

        return n-count;
    }
}