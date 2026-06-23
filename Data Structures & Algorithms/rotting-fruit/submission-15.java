class Solution {
    int[][] DIRS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public int orangesRotting(int[][] grid) {
        /*
        I'll use multi-source BFS starting from all rotten fruits simultaneously. 
        spread the rotten fruits to adjacent fresh fruits Level by level and track the time. 
        Finally, if all fruits are rotten return the time, otherwise return -1

        We need freshCnt > 0 to ensure time accuracy. 
        If all fresh fruits are already rotten but the queue still has remaining elements, 
        continuing the loop would increment time unnecessarily and give a wrong answer.
        */
        Queue<int[]> q = new ArrayDeque<>();
        int freshCnt = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1) freshCnt++;
                else if(grid[i][j] == 2) q.offer(new int[]{i, j});
            }
        }

        int time = 0;
        while(!q.isEmpty() && freshCnt > 0){
            int size = q.size();
            for(int s = 0; s < size; s++){
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
