class Solution {
    private static final int[][] DIRS = {{0,1}, {0,-1}, {-1,0}, {1,0}};
    public void islandsAndTreasure(int[][] grid) {
        // 记录land到最近treasure的距离，bfs
        // 我们可以从treasure出发，treasure本身step是0
        // 先把所有的treasure位置记录下来，放进queue
        // 不断pop出位置，往四周扩散
        // 如果遇到是inf，将其改为cur val + 1,放进queue
        // else 直接return
        Queue<int[]> q = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 0){
                    q.add(new int[]{i, j});
                }
            }
        }
        if(q.size() == 0) return;
        while(!q.isEmpty()){
            int[] node = q.poll();
            int row = node[0];
            int col = node[1];
            for(int[] dir : DIRS){
                int r = row + dir[0];
                int c = col + dir[1];
                if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] != Integer.MAX_VALUE){
                    continue;
                }
                q.add(new int[]{r, c});
                grid[r][c] = grid[row][col] + 1;
            }
        }
    }
}
