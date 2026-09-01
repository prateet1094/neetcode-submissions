class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int m = matrix.length;
        int n = matrix[0].length;
        int row = 0;

        int top = 0;
        int bottom = m-1;
        while(top<=bottom){
            int mid = top + (bottom-top)/2;
            if(matrix[mid][0]==target){
                return true;
            } else if(matrix[mid][0]>target){
                bottom = mid-1;
                row = mid-1;
            } else {
                if(target>matrix[mid][n-1]){
                    row = mid+1;
                    top = mid+1;
                } else {
                    row = mid;
                    top = mid;
                    break;
                }
            }
        }

        int left = 0;
        int right = n-1;

        while(left<=right && row>=0 && row<m){
            int mid = left + (right-left)/2;
            if(matrix[row][mid]==target)return true;
            else if(matrix[row][mid]>target) right = mid-1;
            else left = mid+1;
        }
        return false;
        
    }
}
