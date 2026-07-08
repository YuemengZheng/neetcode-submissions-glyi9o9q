class Solution {
    int res = 0;
    List<Integer> path = new ArrayList<>();
    public int totalNQueens(int n) {
        // each level represent the row
        // at each row, try to choose a valid col to place the queen
        // use a helper function backtacking to cnt all the paths: 
        // - inputs: n
        // base case: if size of the path equals n, increment the res
        // try each col and check validation, if it is valid, recurse on the next row
        backtrack(n);
        return res;
    }
    private void backtrack(int n) {
        if(path.size() == n) {
            res++;
        }

        for(int col = 0; col < n; col++) {
            if(isValid(col)){
                path.add(col);
                backtrack(n);
                path.remove(path.size() - 1);
            }
        }
    }
    private boolean isValid(int col) {
        int row = path.size();
        for(int i = 0; i < path.size(); i++) {
            if(path.get(i) == col || Math.abs(path.get(i) - col) == row - i){
                return false;
            }
        }
        return true;
    }
}