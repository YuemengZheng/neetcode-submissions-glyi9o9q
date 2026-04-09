class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // ***** TIME: O(log(n + m)), SPACE:O(1) *****
        // treat the 2d array as a long array by convert its index
        int n = matrix.length;
        int m = matrix[0].length;
        int left = 0, right = n * m  - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            int x = mid / m;
            int y = mid % m;
            if(matrix[x][y] == target){
                return true;
            }else if(matrix[x][y] < target){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return false;
    }
}
