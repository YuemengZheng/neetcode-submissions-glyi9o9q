class Solution {
    public boolean isValidSudoku(char[][] board) {
        /* 
        The idea is to scan the board and check whether a digit has already appeared 
        in the same row, column, or 3×3 box.
        To track this efficiently, we use three boolean arrays to record 
        whether a digit has been seen in each row, column, and box.
        If we encounter a digit that has already appeared in any of these, the board is invalid.

        use boolean array to record row, col, box
        rows[i][num] = true   -> 数字 num 在第 i 行出现过
        cols[j][num] = true   -> 数字 num 在第 j 列出现过
        boxes[box][num] = true -> 数字 num 在第 box 个 3x3 宫出现过
        */
        // ***** TIME: O(1), SPACE:O(1) *****
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] boxes = new boolean[9][9];
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                char c = board[i][j];
                if(c == '.'){
                    continue;
                }
                int num = c - '1';// convert the digit from character to an index from 0 to 8
                int box = (i / 3) * 3 + j / 3; // compute which box the cell belongs to
                if(rows[i][num] || cols[j][num] || boxes[box][num]){
                    return false;
                }
                rows[i][num] = true;
                cols[j][num] = true;
                boxes[box][num] = true;
            }
        }
        return true;
    }
}
