class Solution {
    private static final int[][] DIRS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public int maxAreaOfIsland(int[][] grid) {
        // *********TC: O(n * m), SC: O(n * m)*********
        int n = grid.length;
        int m = grid[0].length;
        int maxArea = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1){
                    int curArea = dfs(grid, i, j);
                    maxArea = Math.max(maxArea, curArea);
                }
            }
        }
        return maxArea;
    }
    private int dfs(int[][] grid, int i, int j){
        // base case 
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0){
            return 0;
        }
        // recursion rule
        // mark visited
        grid[i][j] = 0;
        // in 4 dirs
        // 相当于收集每个分支的area，加上当前节点1，返回
        int area = 1;
        for(int[] dir : DIRS){
            area += dfs(grid, i + dir[0], j + dir[1]);
        }
        return area;
    }
}
