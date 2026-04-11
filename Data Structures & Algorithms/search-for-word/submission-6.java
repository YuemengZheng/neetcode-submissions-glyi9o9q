class Solution {
    int[][] DIRS = new int[][]{{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    public boolean exist(char[][] board, String word) {
        /*
        We try each cell as a possible starting point.
        For each starting point, we use backtracking to match the word.
        At each recursion level, we check if the current cell matches the current character.
        If it matches, we explore four directions to match the next character.
        If we match all characters in the word, we return true. Otherwise, we return false. 
        */
        int m = board.length;
        int n = board[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(backtrack(i, j, 0, word, board)){
                    return true;
                }
            }
        }
        return false; 
    }
    private boolean backtrack(int i, int j, int cur, String word, char[][] board){
        if(cur == word.length()){
            return true;
        }

        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(cur)){
            return false;
        }

        char temp = board[i][j];
        board[i][j] = '#';

        for(int[] dir : DIRS){
            int x = dir[0] + i;
            int y = dir[1] + j;
            if(backtrack(x, y, cur + 1, word, board)){
                board[i][j] = temp;
                return true;
            }
        }

        board[i][j] = temp;
        return false;
    }
}
