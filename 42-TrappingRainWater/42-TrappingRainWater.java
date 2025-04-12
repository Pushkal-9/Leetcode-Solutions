// Last updated: 11/04/2025, 21:54:14
class Solution {
    public int trap(int[] height) {
        int[] left = new int[height.length];
        int[] right = new int[height.length];


        left[0]=0;
        for(int i=1;i<height.length;i++){
            left[i]= Math.max(left[i-1],height[i-1]);
        }


        right[height.length-1]=0;

        for(int i=height.length-2;i>=0;i--){
            right[i]=Math.max(height[i+1],right[i+1]);
        }

        int total = 0;

        for(int i=0;i<height.length;i++){
            int min = Math.min(left[i],right[i]);
            if(min>height[i])
                total = total + min-height[i];
        }

        return total;
    }
}