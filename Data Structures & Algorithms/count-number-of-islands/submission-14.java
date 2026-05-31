class Solution {
    int[][] DIRS = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    public int numIslands(char[][] grid) {
        // use dfs
        // for each cell in the grid, treat it as the start of the island
        // use dfs to mark all the connected lands
        // collect the number of islands
        int res = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1'){
                    res++;
                    dfs(i, j, grid);
                }
            }
        }
        return res;
    }
    private void dfs(int i, int j, char[][] grid){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0'){
            return;
        }

        grid[i][j] = '0';
        
        for(int[] dir : DIRS){
            int x = i + dir[0];
            int y = j + dir[1];
            dfs(x, y, grid);
        }
    }
}
