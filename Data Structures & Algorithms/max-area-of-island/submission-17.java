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
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) return 0;
        grid[i][j] = 0;
        int cnt = 1;
        for(int[] dir : DIRS){
            int x = i + dir[0];
            int y = j + dir[1];
            cnt += dfs(x, y, grid);
        }
        return cnt;
    }
}
