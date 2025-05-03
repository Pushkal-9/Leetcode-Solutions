// Last updated: 03/05/2025, 18:21:55
class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {

        int min = Integer.MAX_VALUE;
        boolean pos = false;

        for(int i=1;i<=6;i++){
            int current = i;
            int count = 0;
            int topCount = 0;
            int bottomCount = 0;
            for(int j=0;j<tops.length;j++){
                if(tops[j]==current || bottoms[j]==current){
                    count++;
                }

                if(tops[j]==current){
                    topCount++;
                }
                if(bottoms[j]==current){
                    bottomCount++;
                }
            }

            if(count == tops.length){
                min = Math.min(min, Math.min(topCount, tops.length-topCount));
                min = Math.min(min, Math.min(bottomCount, tops.length-bottomCount));
                pos = true;
            }
        }

        if(pos){
            return min;
        }

        return -1;
    }
}