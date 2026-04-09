class Solution {
    public int orangesRotting(int[][] grid) {
        // Return the minimum number of minutes  =》 bfs
        // initialize a queue with positions of all rotten oranges
        // count total number of fresh oranges
        // while the queue is not empty and fresh oranges exist:
            // process one bfs level
            // for each rotten fruit:
                // check its 4 neis
                // if a nei is fresh
                    // make it rotten
                    // decrease the fresh count
                    // add it to the queue
            // increase time by 1
        // if fresh count == 0, return time, else return -1
        Queue<int[]> q = new ArrayDeque<>();
        int fresh = 0;
        int time = 0;

        for(int r = 0; r < grid.length; r++){
            for(int c = 0; c < grid[0].length; c++){
                if(grid[r][c] == 1){
                    fresh++;
                }else if(grid[r][c] == 2){
                    q.offer(new int[]{r, c});
                }
            }
        }

        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while(fresh > 0 && !q.isEmpty()){
            int length = q.size();// for each bfs level
            for(int i = 0; i < length; i++){
                int[] cur = q.poll();
                int r = cur[0];
                int c = cur[1];

                for(int[] dir : dirs){
                    int row = r + dir[0];
                    int col = c + dir[1];
                    if(row >= 0 && row < grid.length && 
                    col >= 0 && col < grid[0].length && 
                    grid[row][col] == 1){
                        grid[row][col] = 2;
                        q.offer(new int[]{row, col});
                        fresh--;
                    }
                }
            }
            time++;
        }
        return fresh == 0 ? time : -1;
    }
}
