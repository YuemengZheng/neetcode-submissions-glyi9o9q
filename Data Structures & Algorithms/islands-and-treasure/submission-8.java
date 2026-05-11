class Solution {
    private static final int[][] DIRS = {{0,1}, {0,-1}, {-1,0}, {1,0}};
    public void islandsAndTreasure(int[][] grid) {
        // *********TC: O(n * m), SC: O(n * m)*********
        // 记录land到最近treasure的距离，bfs
        // 我们可以从treasure出发，treasure本身step是0
        // 先把所有的treasure位置记录下来，放进queue
        // 不断pop出位置，往四周扩散
        // 如果遇到是inf，将其改为cur val + 1,放进queue
        // else 直接return
        Queue<int[]> q = new LinkedList<>();
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
                if(x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == Integer.MAX_VALUE){
                    q.offer(new int[]{x, y});
                    grid[x][y] = grid[i][j] + 1;
                }
            }
        }
    }
}
