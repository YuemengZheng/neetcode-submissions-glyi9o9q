class Solution {
    public boolean isValidSudoku(char[][] board) {
        // check validation from three parts
        // row, col, sub-box
        // use three boolean matix to store the info
        // 1. i -> row, j -> digit, row[i][j] -> if i row contains digit j 
        // 2. i -> col, j -> digit, row[i][j] -> if i col contains digit j 
        // 3. i -> sub-box, j -> digit, row[i][j] -> if ith sub-box contains digit j 
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] boxes = new boolean[9][9];
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                char c = board[i][j];
                if(c == '.') continue;
                int digit = c - '1';
                if(rows[i][digit] || cols[j][digit] || boxes[(i / 3) * 3 + j / 3][digit]) return false;
                rows[i][digit] = true;
                cols[j][digit] = true;
                boxes[(i / 3) * 3 + j / 3][digit] = true;
            }
        }
        return true;
    }
}
