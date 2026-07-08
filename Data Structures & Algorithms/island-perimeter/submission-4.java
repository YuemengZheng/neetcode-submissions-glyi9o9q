class Solution {
    int[][] DIRS = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public int islandPerimeter(int[][] grid) {
        /*
        High level:
        "The key insight is that each edge of the perimeter is where a land cell 
        touches water or the boundary. So I use DFS starting from any land cell, 
        and for each direction, if the neighbor is water or out of bounds, it contributes one edge."

        Main steps:
        "The helper function takes the grid and current position.
        Base case: if out of bounds or water, return 1. If already visited, return 0.
        Otherwise, mark the cell as visited, explore all four directions, and sum up the contributions."

        TC & SC:
        "Time complexity is O(m * n) since we visit each cell at most once. 
        Space complexity is O(m * n) for the recursion stack in the worst case."
        */
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