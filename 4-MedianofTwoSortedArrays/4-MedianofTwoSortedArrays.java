// Last updated: 21/04/2025, 01:01:42
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int first = nums1.length;
        int second = nums2.length;

        int total = first + second;

        int half = total/2;

        int left = 0;
        int right = nums1.length;

        while(true){
            int mid = (left+right)/2;
            int rem = half - mid;

            int firstLeft = mid>0 ? nums1[mid-1] : Integer.MIN_VALUE;
            int secondLeft = rem>0 ? nums2[rem-1] : Integer.MIN_VALUE;
            int secondRight = rem<second ? nums2[rem] : Integer.MAX_VALUE;
            int firstRight = mid<first ? nums1[mid] : Integer.MAX_VALUE;

            if(firstLeft<=secondRight && secondLeft<=firstRight){
                if(total%2==0){
                    return (double)(Math.max(firstLeft,secondLeft) + Math.min(secondRight,firstRight))/(double)2;
                }
                return (double)Math.min(firstRight,secondRight);
            }
            else if(firstLeft>secondRight){
                right = right-1;
            }
            else{
                left = left+1;
            }

        }
    }
}