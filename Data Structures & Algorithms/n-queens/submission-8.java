class Solution {
    List<List<String>> res = new ArrayList<>();
    List<Integer> rowToCol = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        /*
        I'll use backtracking. 
        Each level represents a row, and I try placing a queen in each column. 
        If valid, recurse on the next row. 
        When all rows are filled, collect the result.

        Time is O(n! * n) — similar to permutation, times O(n) for validation. 
        Space is O(n) for the recursion stack.
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
