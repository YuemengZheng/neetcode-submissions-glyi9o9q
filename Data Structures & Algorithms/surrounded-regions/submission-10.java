class Solution {
    private int[][] DIRS = {{1, 0}, {-1, 0},
                                  {0, 1}, {0, -1}};
    public void solve(char[][] board) {
        // our goal is to convert all the 0s that are surrounded by the x's to x
        // the dificulty is that, we need to distinguish the 0s that surrounded by xs and near the border
        // so we can start from four borders to mark all the 0s that connected to the border
        // convert the 0s that has not been marked to x
        int m = board.length;
        int n = board[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(i == 0 || i == m - 1 || j == 0 || j == n - 1){
                    dfs(i, j, board);
                }
            }
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }else if(board[i][j] == 'T'){
                    board[i][j] = 'O';
                }
            }
        }
    }
    private void dfs(int i, int j, char[][] board){
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != 'O'){
            return;
        }
        board[i][j] = 'T';
        for(int[] dir : DIRS){
            int x = i + dir[0];
            int y = j + dir[1];
            dfs(x, y, board);
        }
    }
}
