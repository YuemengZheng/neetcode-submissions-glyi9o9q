class Solution {
    int[][] DIRS = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public void islandsAndTreasure(int[][] grid) {
        // nearest distance -> use bfs
        // start from all the treasure chests at the same time
        // try to explore in four directions and mark the land cell with the steps

        // find all the cells that is treasure chest
        // put then in the queue
        // explore level by level
        
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
            for(int[] dir : DIRS){
                int x = cur[0] + dir[0];
                int y = cur[1] + dir[1];
                if(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] != Integer.MAX_VALUE) continue;
                grid[x][y] = grid[cur[0]][cur[1]] + 1;
                q.offer(new int[]{x, y});
            }
        }
    }
}
