class Solution {
    public int trap(int[] height) {
        int[] left = new int[height.length];
        int[] right = new int[height.length];

        left[0]=0;

        for(int i=1;i<height.length;i++){
            left[i]= Math.max(height[i-1],left[i-1]);
        }

        right[height.length-1]=0;

        for(int j=height.length-2;j>=0;j--){
            right[j] = Math.max(height[j+1],right[j+1]);
        }

        int total = 0;

        for(int i=1;i<height.length-1;i++){
            int min = Math.min(left[i],right[i]);

            //System.out.println(left[i] + " "+ right[i]);
            total = total + (min>height[i]?min-height[i]:0);
        }

        return total;
    }
}