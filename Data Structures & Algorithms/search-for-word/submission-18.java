class Solution {
    int[][] DIRS = new int[][]{{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
    boolean[][] visited;
    public boolean exist(char[][] board, String word) {
        // use backtrack
        // for each letter in the board, treat each letter as the start of the target string
        // and apply the backtracking on it
        // for each step, try for directions to find next letter
        // when we find the target word, return true, else return false
        int m = board.length;
        int n = board[0].length;
        visited = new boolean[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(backtrack(i, j, 0, word, board)){
                    return true;
                }
            }
        }
        return false;
    }
    private boolean backtrack(int i, int j, int index, String word, char[][] board){
        if(index == word.length()){
            return true;
        }
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length 
        || visited[i][j] || board[i][j] != word.charAt(index)){
            return false;
        }

        visited[i][j] = true;
        for(int[] dir : DIRS){
            int x = dir[0] + i;
            int y = dir[1] + j;
            /*
            把边界的检查写在这会有一个问题，当我们已经找到了word，但是index + 1是越界的，我们就没办法触及base case return true
            所以把边界check写在 index == word.length()这个base case的下面，确保都能有机会check到！！！
            if(x >= 0 && x < board.length && y >= 0 && y < board[0].length && !visited[x][y]){
                if(backtrack(x, y, index + 1, word, board)){
                    return true;
                }
            }
            */
            if(backtrack(x, y, index + 1, word, board)){
                return true;
            }

        }
        visited[i][j] = false;
        return false;  
    }
}
