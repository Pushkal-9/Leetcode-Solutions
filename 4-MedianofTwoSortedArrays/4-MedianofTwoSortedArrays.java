// Last updated: 16/06/2025, 20:03:47
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        if(m>n){
            return findMedianSortedArrays(nums2,nums1);
        }

        int total = m+n;

        int half = (m+n)/2;

        int left = 0, right = m;

        while(true){
            int mid1 = (left+right)/2;
            int mid2 = half - mid1;

            int left1 = (mid1==0) ? Integer.MIN_VALUE : nums1[mid1-1];
            int right1 = (mid1==m) ? Integer.MAX_VALUE : nums1[mid1];

            int left2 = (mid2==0) ? Integer.MIN_VALUE : nums2[mid2-1];
            int right2 = (mid2==n) ? Integer.MAX_VALUE : nums2[mid2];

            if(left1 <= right2 && left2 <= right1){

                if(total%2==0){
                    return (double)(Math.max(left1,left2) + Math.min(right1,right2))/2;
                }

                return Math.min(right1,right2);
            }
            else if(left1 > right2){
                right = mid1-1;
            }
            else{
                left = mid1+1;
            }
        }
    }
}