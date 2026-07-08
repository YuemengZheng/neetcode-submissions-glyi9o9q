class Solution {
    int[][] DIRS = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public int islandPerimeter(int[][] grid) {
        // 按照cell的个数推算的都不行，因为排列千变万化，没办法计算
        // 从边长是什么开始出发，当前是land但是和水接触的算边长
        // 所以我们先找到land，然后traverse from it
        // base case: 当我们访问过的节点，返回0，遇到越界或者是水的返回1
        // 将当前的land 设置成other int =》 2
        // explore from 4 dirs to get the cnt, sum them up and return
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    return traverse(i, j, grid);
                }
            }
        }
        return 0;
    }
    private int traverse(int i, int j, int[][] grid) {
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) return 1;
        if(grid[i][j] == 2) return 0;

        grid[i][j] = 2;
        int cnt = 0;
        for(int[] dir : DIRS) {
            int x = i + dir[0];
            int y = j + dir[1];
            cnt += traverse(x, y, grid);
        }

        return cnt;
    }

}