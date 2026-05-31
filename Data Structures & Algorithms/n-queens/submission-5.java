class Solution {
    List<List<String>> res = new ArrayList<>();
    List<Integer> rowToCol = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        // 创建list of string fill with ‘.’
        // use backtracking
        // each reucursion tree represents each row, for each level, we choose to pick one col
        // and check validation, if it is valid, recurse on the next level, 
        // when we reach the final row, collect the result
        backtrack(n);
        return res;
    }
    private void backtrack(int n){
        if(rowToCol.size() == n){
            res.add(getPath(n));
            return;
        }

        for(int col = 0; col < n; col++){
            if(!ifValid(col)) continue;
            rowToCol.add(col);
            backtrack(n);
            rowToCol.remove(rowToCol.size() - 1);
        }
    }
    private boolean ifValid(int col){
        int row = rowToCol.size();
        for(int i = 0; i < row; i++){
            int j = rowToCol.get(i);
            if(col == j || Math.abs(col - j) == Math.abs(row - i)) return false;
        }
        return true;
    }
    private List<String> getPath(int n){
        List<String> path = new ArrayList<>();
        for(int i = 0; i < n; i++){
            char[] row = new char[n];
            Arrays.fill(row, '.');
            row[rowToCol.get(i)] = 'Q';
            path.add(new String(row));
        }
        return path;
    }
}
