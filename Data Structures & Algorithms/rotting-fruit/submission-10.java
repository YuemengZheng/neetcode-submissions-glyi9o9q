class Solution {
    int[][] DIRS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public int orangesRotting(int[][] grid) {
        // multi-source bfs
        // start from all the rotten fruit simul
        // explore in four directions level by level
        // when we meet the fresh fruit, mark it as rotten fruit
        // finnally check if all the fruit has been rooten, if so return the time
        // otherwise return -1

        // get the number of fresh fruits and get the position of rotten fruits
        Queue<int[]> q = new ArrayDeque<>();
        int freshCnt = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1) freshCnt++;
                else if(grid[i][j] == 2){
                    q.offer(new int[]{i, j});
                }
            }
        }
        int time = 0;
        while(!q.isEmpty() && freshCnt > 0){
            int size = q.size();
            for(int k = 0; k < size; k++){
                int[] cur = q.poll();
                int i = cur[0];
                int j = cur[1];
                for(int[] dir : DIRS){
                    int x = i + dir[0];
                    int y = j + dir[1];
                    if(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] != 1) continue;
                    grid[x][y] = 2;
                    freshCnt--;
                    q.offer(new int[]{x, y});
                }
            }
            time++;  
        }
        return freshCnt == 0 ? time : -1;
    }
}
