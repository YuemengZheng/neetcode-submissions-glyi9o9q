class Solution {
    int[][] DIRS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public int numIslands(char[][] grid) {
        // bfs
        int res = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1'){
                    res++;
                    Queue<int[]> q = new ArrayDeque<>();
                    q.offer(new int[]{i, j});
                    grid[i][j] = '0';
                    bfs(q, grid);
                }
            }
        }
        return res;
    }
    private void bfs(Queue<int[]> q, char[][] grid){
        while(!q.isEmpty()){
            int[] cur = q.poll();
            for(int[] dir : DIRS){
                int x = cur[0] + dir[0];
                int y = cur[1] + dir[1];
                if(x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == '1'){
                    q.offer(new int[]{x, y});
                    grid[x][y] = '0';
                }
            }
        }
        
    }
}
