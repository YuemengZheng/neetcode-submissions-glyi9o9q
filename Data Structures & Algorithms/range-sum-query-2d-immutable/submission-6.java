class NumMatrix {
    int[][] prefixSum;
    public NumMatrix(int[][] matrix) {
        /*
        High Level
        "I'll use a 2D prefix sum. I precompute a prefix sum matrix once in the constructor, 
        where each cell stores the sum of all elements from the top-left corner to that position. 
        Then each sumRegion query can be answered in O(1)."

        Main Steps
        "There are two parts:
        First, building the prefix sum. I create a matrix with one extra row and column of zeros as a border, 
        so I don't have to handle edge cases. For each cell, its prefix sum is the cell above, 
        plus the cell to the left, minus the overlapping region that was counted twice, plus the current value.

        Second, answering a query. To get the sum of a sub-rectangle, 
        I take the full rectangle, subtract the top and left parts, then add back the overlap that got removed twice
        */
        int m = matrix.length;
        int n = matrix[0].length;
        prefixSum = new int[m + 1][n + 1];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                prefixSum[i + 1][j + 1] = prefixSum[i][j + 1] + prefixSum[i + 1][j] - prefixSum[i][j] + matrix[i][j];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return prefixSum[row2 + 1][col2 + 1] - prefixSum[row1][col2 + 1] - prefixSum[row2 + 1][col1] + prefixSum[row1][col1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */