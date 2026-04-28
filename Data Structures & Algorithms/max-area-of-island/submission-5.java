class Solution {
    private static final int[][] DIRS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public int maxAreaOfIsland(int[][] grid) {
        // *********TC: O(n * m), SC: O(n * m)*********
        int m = grid.length;
        int n = grid[0].length;
        int maxArea = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                maxArea = Math.max(maxArea, dfs(i, j, grid));
            }
        }
        return maxArea;
    }
    private int dfs(int i, int j, int[][] grid){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0){
            return 0;
        }

        grid[i][j] = 0;
        int curArea = 1;
        for(int[] dir : DIRS){
            int x = dir[0] + i;
            int y = dir[1] + j;
            curArea += dfs(x, y, grid);
        }
        return curArea;
    }
   
}
