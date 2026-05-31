class Solution {
    int[][] DIRS = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public int maxAreaOfIsland(int[][] grid) {
        /*
        use dfs, for each unvisited lan cell, apply dfs on it to get the area of the connected land
        update the global max area, finnaly return global max
        */
        int max = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    max = Math.max(dfs(i, j, grid), max);
                }
            }
        }
        return max;
    }
    private int dfs(int i, int j, int[][] grid){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0){
            return 0;
        }

        int cnt = 1;
        grid[i][j] = 0;
        for(int[] dir : DIRS){
            int x = i + dir[0];
            int y = j + dir[1];
            cnt += dfs(x, y, grid);
        }
        return cnt;
    }
}
