class Solution {
    List<List<String>> res = new ArrayList<>();
    List<Integer> rowToCol = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        /*
        use backtrack to get all the solutions to the n-queens puzzle
        each level represents one row
        for each level, we try all the cols to put the queen
        if the position is valid, recurse on the next row
        when we put all the queens, we collect a valid solution
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
