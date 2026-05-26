class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // 将matrix视为一维arr
        int m = matrix.length;
        int n = matrix[0].length;
        int l = 0;
        int r = m * n - 1;
        while(l <= r){
            int mid = l + (r - l) / 2;
            int x = mid / n;
            int y = mid % n;
            if(matrix[x][y] == target){
                return true;
            }else if(matrix[x][y] < target){
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }
        return false;
    }
}
