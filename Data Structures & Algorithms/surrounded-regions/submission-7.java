class Solution {
    private int rows;
    private int cols;
    private int[][] DIRS = {{1, 0}, {-1, 0},
                                  {0, 1}, {0, -1}};
    public void solve(char[][] board) {
        /*
        The brute force approach is to start from each cell and check whether it can reach the border, 
        but that would be inefficient due to repeated DFS.
        Instead, we reverse the idea. We start from the border cells 
        and run DFS to mark all the 'O' cells connected to the border as 'T'.
        These cells cannot be captured.
        Then we traverse the board again:
        change all remaining 'O' to 'X'
        change 'T' back to 'O'
        */

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
        // 最后的范围内只会有x和t，都要返回！！！
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
