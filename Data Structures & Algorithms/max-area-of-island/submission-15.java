class Solution {
    private static final int[][] DIRS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public int maxAreaOfIsland(int[][] grid) {
        // *********TC: O(n * m), SC: O(n * m)*********
        /*
        I'll use DFS. 
        For each unvisited land cell, 
        I apply DFS to calculate the connected island area 
        Finally return the max area.
        */

        int m = grid.length;
        int n = grid[0].length;
        int res = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    res = Math.max(res, dfs(i, j, grid));
                }
            }
        }
        return res;
    }
    private int dfs(int i, int j, int[][] grid){
        // 每一层我们统计当前层的cnt为1
        // 用dfs统计累加下层的cnt
        // 返回累加结果给上一级
        int cnt = 1;
        grid[i][j] = 0;
        for(int[] dir : DIRS){
            int x = dir[0] + i;
            int y = dir[1] + j;
            if(x >= 0 && x < grid.length && y >=0 && y < grid[0].length && grid[x][y] == 1){
                cnt += dfs(x, y, grid);
            }
        }
        return cnt;
    }
}
