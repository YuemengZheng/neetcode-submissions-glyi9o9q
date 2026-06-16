class Solution {
    int[][] DIRS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        // start from the border to the inside, the cover area that has been visited by two kinds of oceans
        // is the answer
        // use a boolean matrix to avoid revisit
        int m = heights.length;
        int n = heights[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        // start from the border to innner and mark the reacheable area
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(i == 0 || j == 0){
                    dfs(i, j, heights, pacific);
                }
                if(i == m - 1 || j == n - 1){
                    dfs(i, j, heights, atlantic);
                }
            }
        }
        // get the merge area
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(pacific[i][j] && atlantic[i][j]){
                    res.add(Arrays.asList(i, j));
                }
            }
        }
        return res;
    }
    private void dfs(int i, int j, int[][] height, boolean[][] visited){
        if(visited[i][j]) return;

        visited[i][j] = true;
        for(int[] dir : DIRS){
            int x = i + dir[0];
            int y = j + dir[1];
            if(x >= 0 && x < height.length && y >= 0 && y < height[0].length && height[i][j] <= height[x][y]){
                dfs(x, y, height, visited);
            }
        }

    }
}
