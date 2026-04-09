class Solution {
    private static final int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public int numIslands(char[][] grid) {
        // Number of Islands - DFS / BFS
        // Traverse the entire grid.
        // Whenever we find a land cell ('1'), we increment the island count
        // and start a DFS/BFS to explore all connected land cells in 4 directions.
        // During the exploration, we mark visited land cells by changing '1' to '0'
        // to avoid revisiting the same cell.

        int ROWS = grid.length, COLS = grid[0].length;
        int cnt = 0;
        for(int r = 0; r < ROWS; r++){
            for(int c = 0; c < COLS; c++){
                if(grid[r][c] == '1'){
                    dfs(grid, r, c);
                    cnt++;
                }
            }
        }
        return cnt;
    }
    private void dfs(char[][] grid, int r, int c){
        // 四处走，其实是先顺着一个方向走到底，再退回走分叉，所以最终结果肯定是出界或者走到0返回
        if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == '0'){
            return;
        }
        // avoid revisiting
        grid[r][c] = '0';
        // explore in 4 dirs
        for(int[] dir : dirs){
            dfs(grid, r + dir[0], c + dir[1]);
        }
    }
}

