class Solution {
    private int rows;
    private int cols;
    private int[][] dirs = {{1, 0}, {-1, 0},
                                  {0, 1}, {0, -1}};
    public void solve(char[][] board) {
        // 找到在边界的为0的，然后开始dfs，把和边界相连的0区域标记出来
        // 最后把标记的都改成0，其余的改成x
        // All cells in first/last column. All cells in first/last row.
        // if it is “0”， start dfs
        // *********TC: O(n * n), SC: O(n * m)*********
        rows = board.length;
        cols = board[0].length;

        for(int r = 0; r < rows; r++){
            if(board[r][0] == 'O'){
                dfs(board, r, 0);
            }
            if(board[r][cols - 1] == 'O'){
                dfs(board, r, cols - 1);
            }
        }

        for(int c = 0; c < cols; c++){
            if(board[0][c] == 'O'){
                dfs(board, 0, c);
            }
            if(board[rows - 1][c] == 'O'){
                dfs(board, rows - 1, c);
            }
        }
        for(int r = 0; r < rows; r++){
            for(int c = 0; c < cols; c++){
                if(board[r][c] == 'O'){
                    board[r][c] = 'X';
                }else if(board[r][c] == 'T'){
                    board[r][c] = 'O';
                }
            }

        }

    }
    private void dfs(char[][] board, int r, int c){
        if(r < 0 || c < 0 || r >= rows || c >= cols || board[r][c] != 'O'){
            return;
        }
        board[r][c] = 'T';
        for(int[] dir : dirs){
            int x = r + dir[0];
            int y = c + dir[1];
            dfs(board, x, y);
        }
    }
}
