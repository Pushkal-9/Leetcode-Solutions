// Last updated: 14/04/2025, 16:02:27
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int row = findRow(matrix,target);

        int low = 0;
        int high = matrix[0].length-1;

        if (row < 0 || row >= matrix.length || matrix[row][0] > target) {
            return false;
        }

        //System.out.println(row);


        while(low<=high){
            int mid = (high-low)/2 + low;

            if(matrix[row][mid]==target){
                return true;
            }
            else if(matrix[row][mid]>target){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        
        return false;
    }

    public int findRow(int[][] matrix, int target){
        int low = 0;
        int high = matrix.length-1;

        while(low<=high){
            int mid = (high-low)/2 + low;

            if(matrix[mid][0]==target){
                return mid;
            }
            else if(matrix[mid][0]>target){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }

        return high;
    }
}