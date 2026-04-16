class Solution {
    private int[][] DIRS = {{1, 0}, {-1, 0},
                                  {0, 1}, {0, -1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        /*
        The brute force way is to run DFS from each cell to check if it can reach both oceans, 
        tc will be (m * n) * (m * n), that causes a lot of repeated work.
        Instead, we reverse the process. We start from the ocean borders and move inward.
        Since water flows from high to low, in reverse we can only move to neighbors with equal or higher height.
        We run DFS from all Pacific borders and all Atlantic borders to mark reachable cells.
        The cells visited by both searches are the final answer.
        */
        // *********TC: O(n*m), SC: O(n*m)*********
        // use two boolean matrix to record if the cell has been visited
        int m = heights.length;
        int n = heights[0].length;
        boolean[][] pac = new boolean[m][n];
        boolean[][] atl = new boolean[m][n];
        // run dfs from all pacific border and Atlantic border cells
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(i == 0 || j == 0){
                    dfs(i, j, heights, pac);
                }
                if(i == m - 1 || j == n - 1){
                    dfs(i, j, heights, atl);
                }
            }
        }
        // get all the cells visited by both searches
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
    private void dfs(int i, int j, int[][] heights, boolean[][] ifVisited){
        if(ifVisited[i][j]) return;
        ifVisited[i][j] = true;

        for(int[] dir : DIRS){
            int x = i + dir[0];
            int y = j + dir[1];
            if(x >= 0 && x < heights.length && y >= 0 && y < heights[0].length 
            && heights[x][y] >= heights[i][j]){
                dfs(x, y, heights, ifVisited);
            }
        }
    }
}
