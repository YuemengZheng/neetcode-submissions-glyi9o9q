class Solution {
    private int rows;
    private int cols;
    private int[][] DIRS = {{1, 0}, {-1, 0},
                                  {0, 1}, {0, -1}};
    public void solve(char[][] board) {
        // 尝试每一个cell都用dfs，看看能不能reach到边，如果可以，那么这个不用变，如果不可以，我们重新dfs去把里面的cell变成 x
        // 这样很不高效（m * n）* (n * m)
        // 我们要做的是把和边界相连的0都和其他区别开来
        // 所以我们可以从特殊情况开始，从四个边的cell开始 run dfs，把他们标记成t，然后遍历整个matrix
        // 遇到 0 我们标记 x， 遇到t标记0

        // *********TC: O(n * m), SC: O(n * m)*********
        // 把border cells 都找出来， run dfs on it
        int m = board.length;
        int n = board[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(i == 0 || j == 0 || i == m - 1 || j == n - 1){
                    dfs(i, j, board);
                }
            }
        }
        // loop through each cell, mark t as 0, mark 0 as x
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 'T'){
                    board[i][j] = 'O';
                }else if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }
    }
    private void dfs(int i, int j, char[][] board){
        if(board[i][j] == 'X' || board[i][j] == 'T' ) return;

        board[i][j] = 'T';
        for(int[] dir : DIRS){
            int x = dir[0] + i;
            int y = dir[1] + j;
            if(x >= 0 && x < board.length && y >= 0 && y < board[0].length){
                dfs(x, y, board);
            }
        }

    }
    
}
