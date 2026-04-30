class Solution {
    List<List<String>> res = new ArrayList<>();
    List<Integer> rowToCol = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        /*
        We use backtracking to find all valid solutions to the N-Queens problem.
        Each recursion level represents one row, 
        and we try placing a queen in every column of that row.
        Before placing a queen, we check whether the position is valid, 
        meaning it does not conflict with any previously placed queens.
        If the position is valid, we place the queen and recurse to the next row.
        When we successfully place queens in all rows, we collect the current board as one valid solution.
        
        The time complexity is O(n · n!) due to the backtracking search and validity checks.
        The space complexity is O(n) for the recursion stack, excluding the output.
        */

        backtrack(0, n);
        return res;
    }
    private void backtrack(int curRow, int n){
        if(curRow == n){
            res.add(getPath(rowToCol));
            return;
        }

        for(int col = 0; col < n; col++){
            if(isValid(curRow, col)){
                rowToCol.add(col);
                backtrack(curRow + 1, n);
                rowToCol.remove(rowToCol.size() - 1);
            }
        }
    }
    private List<String> getPath(List<Integer> rowToCol){
        List<String> path = new ArrayList<>();
        for(int i = 0; i < rowToCol.size(); i++){
            char[] row = new char[rowToCol.size()];
            Arrays.fill(row, '.');
            row[rowToCol.get(i)] = 'Q';
            path.add(new String(row));
        }
        return path;
    }
    private boolean isValid(int curRow, int curCol){
        for(int row = 0; row < curRow; row++){
            int col = rowToCol.get(row);
            if(curCol == col || Math.abs(curRow - row) == Math.abs(curCol - col)){
                return false;
            }
        }
        return true;
    }
}
