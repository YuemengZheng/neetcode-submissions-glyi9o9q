class Solution {
    int[][] DIRS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public int numIslands(char[][] grid) {
        // *********TC: O(n * m), SC: O(n * m)due to recursion stack *********
        // If the grid is very large, DFS recursion may cause a stack overflow.

        // Number of Islands - DFS / BFS
        // Traverse the entire grid.
        // Whenever we find a land cell ('1'), we increment the island count
        // and start a DFS/BFS to explore all connected land cells in 4 directions.
        // During the exploration, we mark visited land as '0' to avoid revisiting.
        int cnt = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1'){
                    dfs(i, j, grid);
                    cnt++;
                }
            }
        }
        return cnt;
    }
    private void dfs(int i, int j, char[][] grid){
        if(grid[i][j] == '0'){
            return;
        }
        grid[i][j] = '0';
        for(int[] dir : DIRS){
            int x = dir[0] + i;
            int y = dir[1] + j;
            if(x >= 0 && x < grid.length && y >= 0 && y < grid[0].length){
                dfs(x, y, grid);
            }
        }
    }
}

