class Solution {
    int[][] DIRS = {{1, 0}, {-1, 0},
                                  {0, 1}, {0, -1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        /*
        Our goal is to find all cells that can flow to both oceans. 
        Instead of checking each cell individually, we can reverse the direction 
        and start DFS from both oceans inward and mark the reachable cells. 
        So finally, the intersection of two visited sets is our answer.
        The intersection of the two sets is our answer

        Steps — "I'll create two boolean matrices to track reachable cells for each ocean. 
        Then I'll start DFS from the pacific borders (top and left) and atlantic borders (bottom and right). 
        Finally I'll find the intersection.
        Inside DFS, base case: if the cell has been visited, return. otherwise I mark the current cell as visited, 
        then recursively visit all neighbors that are within bounds, 
        not yet visited, and have height greater than or equal to the current cell.
        TC/SC — "Both are O(m * n) since we visit each cell at most twice."
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
