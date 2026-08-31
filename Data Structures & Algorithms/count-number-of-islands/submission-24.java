class Solution {
    int[][] DIRS = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int numIslands(char[][] grid) {
        int cnt = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1') {
                    cnt++;
                    traverse(i, j, grid);
                }
            }
        }
        return cnt;
    }
    private void traverse(int i, int j, char[][] grid) {
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0') return;

        grid[i][j] = '0';
        for(int[] dir : DIRS) {
            int x = dir[0] + i;
            int y = dir[1] + j;
            traverse(x, y, grid);
        }
    }
}
