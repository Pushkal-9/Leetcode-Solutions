class Solution {
    public int maxArea(int[] height) {
        int max = 0;

        int start = 0;
        int end = height.length-1;

        while(start<end){
            int current = (end-start)* Math.min(height[start],height[end]);
            max=Math.max(max,current);

            if(height[start]<height[end]){
                start++;
            }
            else{
                end--;
            }
        }

        return max;
    }
}