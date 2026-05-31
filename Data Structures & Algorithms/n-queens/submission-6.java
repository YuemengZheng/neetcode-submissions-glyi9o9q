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
        backtrack(n);
        return res;
    }
    private void backtrack(int n){
        if(rowToCol.size() == n){
            res.add(getPath(n));
            return;
        }

        for(int col = 0; col < n; col++){
            if(!isValid(col)) continue;
            rowToCol.add(col);
            backtrack(n);
            rowToCol.remove(rowToCol.size() - 1);
        }
    }
    private List<String> getPath(int n){
        List<String> path = new ArrayList<>();
        for(int col : rowToCol){
            char[] row = new char[n];
            Arrays.fill(row, '.');
            row[col] = 'Q';
            path.add(new String(row));
        }
        return path;
    }
    private boolean isValid(int col){
        int row = rowToCol.size();
        for(int i = 0; i < rowToCol.size(); i++){
            int j = rowToCol.get(i);
            if(j == col || Math.abs(j - col) == Math.abs(i - row)) return false;
        }
        return true;
    }
}
