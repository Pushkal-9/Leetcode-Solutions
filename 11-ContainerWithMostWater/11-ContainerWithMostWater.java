// Last updated: 15/05/2025, 16:45:51
class Solution {
    public int maxArea(int[] height) {
        int max = 0;

        int start = 0, end = height.length-1;

        while(start<=end){
            
            max = Math.max(max, Math.min(height[start],height[end]) * (end-start));

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