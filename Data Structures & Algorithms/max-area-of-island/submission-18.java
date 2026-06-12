class Solution {
    int[][] DIRS = new int[][]{{0,1}, {0,-1}, {1,0}, {-1,0}};
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                int cur = dfs(i, j, grid);
                max = Math.max(max, cur);
            }
        }
        return max;
    }
    private int dfs(int i, int j, int[][] grid){
        if(grid[i][j] == 0) return 0;
        int cnt = 1;
        grid[i][j] = 0;
        for(int[] dir : DIRS){
            int x = dir[0] + i;
            int y = dir[1] + j;
            if(x >= 0 && x < grid.length && y >= 0 && y < grid[0].length){
                cnt += dfs(x, y, grid);
            }
        }
        return cnt;
    }
}
