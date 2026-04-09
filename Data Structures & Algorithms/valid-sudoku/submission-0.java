class Solution {
    public boolean isValidSudoku(char[][] board) {
        /* use boolean array to record row, col, box
        rows[i][num] = true   -> 数字 num 在第 i 行出现过
        cols[j][num] = true   -> 数字 num 在第 j 列出现过
        boxes[box][num] = true -> 数字 num 在第 box 个 3x3 宫出现过
        */
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] boxes = new boolean[9][9];
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                char c = board[i][j];
                if(c == '.'){
                    continue;
                }
                int num = c - '1';
                int box = (i / 3) * 3 + j / 3;
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
