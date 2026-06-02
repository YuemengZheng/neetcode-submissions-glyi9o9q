class Solution {
    int[][] DIRS = {{1, 0}, {-1, 0},
                                  {0, 1}, {0, -1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        /*
        our goal is to find all the cells that can flow to the two borders, 
        so Instead of checking each cell individually, we reverse the direction — 
        start DFS from both ocean borders inward, marking all reachable cells. 
        The intersection of the two sets is our answer
        */
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
                // }else if(i == m - 1 || j == n - 1){
                //     dfs(i, j, visitedAtl, heights);
                // }
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
            int x = dir[0] + i;
            int y = dir[1] + j;
            if(x >= 0 && x < heights.length && y >= 0 && y < heights[0].length && !visited[x][y] && heights[i][j] <= heights[x][y]){
                dfs(x, y, visited, heights);
            }
        }
    }
}
