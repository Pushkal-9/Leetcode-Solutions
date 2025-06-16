// Last updated: 16/06/2025, 16:44:29
class Solution {
    public int maxArea(int[] height) {
        int start = 0;
        int end = height.length - 1;

        int max = 0;

        while(start<=end){

            max = Math.max(max, Math.min(height[start],height[end]) *(end-start));
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