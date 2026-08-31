class Solution {
    boolean[][] visited;
    int[][] DIRS = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public boolean exist(char[][] board, String word) {
        // each cell as the start to find the word
        // use boolean matrix to avoid revisiting
        int m = board.length;
        int n = board[0].length;
        visited = new boolean[m][n];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(backtrack(i, j, 0, board, word)) return true;
            }
        }
        return false;
    }
    private boolean backtrack(int i, int j, int index, char[][] board, String word) {
        if(index == word.length()) return true;
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length) return false;
        if(visited[i][j] == true) return false;
        if(board[i][j] != word.charAt(index)) return false;

        visited[i][j] = true;
        for(int[] dir : DIRS) {
            int x = i + dir[0];
            int y = j + dir[1];
            if(backtrack(x, y, index + 1, board, word)) return true;
        }
        visited[i][j] = false;
        return false;
    }
}
