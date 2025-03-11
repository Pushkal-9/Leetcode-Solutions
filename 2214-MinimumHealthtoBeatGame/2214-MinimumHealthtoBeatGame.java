class Solution {
    public long minimumHealth(int[] damage, int armor) {
        long sum = 0;

        for(int i : damage){
            sum = sum + i;
        }

        int level = 0;
        int max = 0;

        for(int i : damage){
            if(i>=armor){
                return Math.max(sum - armor+1,1);
            }
            max=Math.max(max,i);
        }

        return  Math.max(sum-max+1,1);
    }
}