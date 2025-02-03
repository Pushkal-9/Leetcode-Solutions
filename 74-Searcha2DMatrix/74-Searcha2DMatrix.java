class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int start = 0, end = matrix[0].length-1;

        int row = searchRow(matrix,target);
        System.out.println(row);

        while(start<=end){
            int mid = start +(end-start)/2;

            if(matrix[row][mid]==target){
                return true;
            }
            else if(matrix[row][mid]<target){
                start=mid+1;
            }
            else{
                end=mid-1;
            }
        }

        return false;
    }

    public int searchRow(int[][] matrix, int target){
        int start = 0, end = matrix.length-1;

        int mid=0;

        if(matrix[end][0]<=target){
            return end;
        }

        while(start<=end){
            mid = start + (end-start)/2;

            if(matrix[mid][0]==target){
                return mid;
            }
            else if(mid<matrix.length-1 && matrix[mid][0]<target && matrix[mid+1][0]>target){
                return mid;
            }
            else if(matrix[mid][0]<target){
                start = mid+1;
            }
            else{
                end = mid-1;
            }
        }

        return mid;
    }
}