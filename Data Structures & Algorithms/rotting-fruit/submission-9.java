class Solution {
    int[][] DIRS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
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

        // Queue<int[]> q = new ArrayDeque<>();
        // int fresh = 0;
        // int time = 0;

        // for(int r = 0; r < grid.length; r++){
        //     for(int c = 0; c < grid[0].length; c++){
        //         if(grid[r][c] == 1){
        //             fresh++;
        //         }else if(grid[r][c] == 2){
        //             q.offer(new int[]{r, c});
        //         }
        //     }
        // }

        // int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        // while(fresh > 0 && !q.isEmpty()){
        //     int length = q.size();// for each bfs level
        //     for(int i = 0; i < length; i++){
        //         int[] cur = q.poll();
        //         int r = cur[0];
        //         int c = cur[1];

        //         for(int[] dir : dirs){
        //             int row = r + dir[0];
        //             int col = c + dir[1];
        //             if(row >= 0 && row < grid.length && 
        //             col >= 0 && col < grid[0].length && 
        //             grid[row][col] == 1){
        //                 grid[row][col] = 2;
        //                 q.offer(new int[]{row, col});
        //                 fresh--;
        //             }
        //         }
        //     }
        //     time++;
        // }
        // return fresh == 0 ? time : -1;
        Queue<int[]> q = new LinkedList<>();
        int freshCount = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 2){
                    q.offer(new int[]{i, j});
                }
                else if(grid[i][j] == 1){
                    freshCount++;
                }
            }
        }
        int min = 0;
        while(freshCount > 0 && !q.isEmpty()){
            int size = q.size();
            for(int cnt = 0; cnt < size; cnt++){
                int[] cur = q.poll();
                int i = cur[0];
                int j = cur[1];
                for(int[] dir : DIRS){
                    int x = i + dir[0];
                    int y = j + dir[1];
                    if(x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == 1){
                        grid[x][y] = 2;
                        freshCount--;
                        q.offer(new int[]{x, y});
                    }
                }
            }
            min++;
        }
        return freshCount == 0? min : -1;
    }
}
