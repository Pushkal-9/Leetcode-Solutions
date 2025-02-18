import java.util.Arrays;

class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int[] merged = new int[3];

        for(int i=0;i<triplets.length;i++){
            if(triplets[i][0]<=target[0] && triplets[i][1]<=target[1] && triplets[i][2]<=target[2]){
                merged[0]= Math.max(merged[0],triplets[i][0]);
                merged[1]= Math.max(merged[1],triplets[i][1]);
                merged[2]= Math.max(merged[2],triplets[i][2]);                            
                }
        }

        return merged[0]==target[0] && merged[2]==target[2] && merged[1]==target[1];
    }
}