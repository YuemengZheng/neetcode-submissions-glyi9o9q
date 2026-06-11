class Solution {
    int[][] DIRS = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public void islandsAndTreasure(int[][] grid) {
        /*
        I'll use multi-source BFS starting from all treasure chests simultaneously. 
        explore Level by level and update each reachable land cell with the current distance. 
        This guarantees the shortest distance for each cell.
        
        Time and space are both O(m * n) since we visit each cell at most once.
        */
        
        Queue<int[]> q = new ArrayDeque<>();
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 0){
                    q.offer(new int[]{i, j});
                }
            }
        }
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int i = cur[0];
            int j = cur[1];
            for(int[] dir : DIRS){
                int x = i + dir[0];
                int y = j + dir[1];
                if(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] != Integer.MAX_VALUE) continue;
                grid[x][y] = grid[i][j] + 1;
                q.offer(new int[]{x, y});
            }
        }
    }
}
