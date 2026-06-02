class Solution {
    int[][] DIRS = {{1, 0}, {-1, 0},
                                  {0, 1}, {0, -1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        // use dfs
        // find the cells that water can flow from cell to both oceans
        // we can start from the borders inward, find the interaction
        int m = heights.length;
        int n = heights[0].length;
        boolean[][] visitedPac = new boolean[m][n];
        boolean[][] visitedAtl = new boolean[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(i == 0 || j == 0){
                    dfs(i, j, visitedPac, heights);
                }
                if(i == m - 1 || j == n - 1){
                    dfs(i, j, visitedAtl, heights);
                }
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(visitedPac[i][j] && visitedAtl[i][j]){
                    res.add(Arrays.asList(i, j));
                }
            }
        }
        return res;
    }
    private void dfs(int i, int j, boolean[][] visited, int[][] heights){
        visited[i][j] = true;
        for(int[] dir : DIRS){
            int x = i + dir[0];
            int y = j + dir[1];
            if(x >= 0 && x < visited.length && y >= 0 && y < visited[0].length && !visited[x][y] && heights[i][j] <= heights[x][y]){
                dfs(x, y, visited, heights);
            }
        }
    }
}
