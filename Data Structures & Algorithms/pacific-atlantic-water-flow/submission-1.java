class Solution {
    private int[][] dirs = {{1, 0}, {-1, 0},
                                  {0, 1}, {0, -1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        // use dfs
        // brute force: for each cell, Run DFS exploring all paths that keep going to same or lower heights
        // there will be repeated work
        // 因为第一行和第一列一定是可以抵达p，最后一行和最后一列一定可以抵达s
        // 所以我们尝试从四周往中间走，他们重合的点就是最终答案

        // start from the ocean borders and keep moving to same or higher heights
        // So we do 2 DFS runs:
        // From all Pacific border cells → mark all reachable cells 
        // From all Atlantic border cells → mark all reachable cells 
        // Answer = cells that are in both sets.
        int rows = heights.length, cols = heights[0].length;
        boolean[][] pac = new boolean[rows][cols];
        boolean[][] atl = new boolean[rows][cols];

        //把边缘的cell都进行dfs
        for(int c = 0; c < cols; c++){
            dfs(0, c, pac, heights);
            dfs(rows - 1, c, atl, heights);
        }
        for(int r = 0; r < rows; r++){
            dfs(r, 0, pac, heights);
            dfs(r, cols - 1, atl, heights);
        }
        List<List<Integer>> res = new ArrayList<>();
        for(int r = 0; r < rows; r++){
            for(int c = 0; c < cols; c++){
                if(pac[r][c] && atl[r][c]){
                    res.add(Arrays.asList(r, c));
                }
            }
        }
        return res;
    }
    private void dfs(int r, int c, boolean[][] ocean, int[][] heights){
        ocean[r][c] = true;
        for(int[]dir : dirs){
            int row = r + dir[0], col = c + dir[1];
            if(row >= 0 && row < heights.length &&
                col >= 0 && col < heights[0].length &&
                !ocean[row][col] && heights[row][col] >= heights[r][c]){
                    dfs(row, col, ocean, heights);
                }
        }
    }
}
