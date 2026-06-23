class Solution {
    int[][] DIRS = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        // use dfs to get visited set of two oceans, the intersection is the answer
        // create two visited matrix
        // itarate through the cells and use dfs to mark all the reacheble cells for each ocean
        // get the intersection
        // TC: O(m * n), SC: O(m * n)

        int m = heights.length;
        int n = heights[0].length;
        boolean[][] pac = new boolean[m][n];
        boolean[][] atl = new boolean[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(i == 0 || j == 0){
                    dfs(i, j, pac, heights);
                }
                if(i == m - 1 || j == n - 1){
                    dfs(i, j, atl, heights);
                }
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(pac[i][j] && atl[i][j]){
                    res.add(Arrays.asList(i, j));
                }
            }
        }
        return res; 
    }
    // mark the reachable cells
    private void dfs(int i, int j, boolean[][] visited, int[][] heights){
        visited[i][j] = true;
        // explore in 4 dirc, if it is in the bound and not visited and >= heights
        for(int[] dir : DIRS){
            int x = i + dir[0];
            int y = j + dir[1];
            if(x >= 0 && x < heights.length && y >= 0 && y < heights[0].length && !visited[x][y] && heights[x][y] >= heights[i][j]){
                dfs(x, y, visited, heights);
            }
        }
    }
}
