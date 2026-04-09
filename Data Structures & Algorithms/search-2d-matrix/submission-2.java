class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // ***** TIME: O(log(n + m)), SPACE:O(1) *****
        // 只要做一个转化就可以
        int n = matrix.length, m = matrix[0].length;
        int l = 0, r = n * m - 1;
        while(l <= r){
            int mid = l + (r - l) / 2;
            int x = mid / m;// 计算第几行，/ cols
            int y = mid % m;// 计算第几列，% cols
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
