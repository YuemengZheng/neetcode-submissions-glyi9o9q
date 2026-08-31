class Solution {
    int[][] DIRS = new int[][]{{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        boolean[][] pac = new boolean[m][n];
        boolean[][] atl = new boolean[m][n];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(i == 0 || j == 0) {
                    traverse(i, j, pac, heights);
                }
                if(i == m - 1 || j == n - 1) {
                    traverse(i, j, atl, heights);
                }
            }
        }

        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(pac[i][j] && atl[i][j]) res.add(Arrays.asList(i, j));
            }
        }
        return res;
    }
    private void traverse(int i, int j, boolean[][] visited, int[][] heights) {
        visited[i][j] = true;
        for(int[] dir : DIRS) {
            int x = i + dir[0];
            int y = j + dir[1];
            if(x >= 0 && x < heights.length && y >= 0 && y < heights[0].length && !visited[x][y] && heights[i][j] <= heights[x][y]){
                traverse(x, y, visited, heights);
            }
        }
    }
}
