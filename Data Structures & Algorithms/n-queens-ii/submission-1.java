class Solution {
    int res = 0;
    List<Integer> path = new ArrayList<>();
    public int totalNQueens(int n) {
        /*
        High level:
        Use backtracking where each level represents a row. At each row, 
        try to place a queen in a valid column. If we successfully place queens in all n rows, increment the result.

        Main steps:
        I use a helper function with input n. 
        I use a path list to record which column each row's queen is placed in.
        Base case: when path size equals n, increment result and return.
        Otherwise, try each column in the current row. 
        For each column, check if it's valid — no queen in the same column or diagonal. 
        If valid, add to path, recurse to the next row, then backtrack by removing it.

        TC & SC:
        Time complexity is O(n!) because the first row has n choices, the second has at most n-1, and so on. 
        Space complexity is O(n) for the recursion stack and path.
        */
        backtrack(n);
        return res;
    }
    private void backtrack(int n) {
        if(path.size() == n) {
            res++;
            return; // 记得return 不然会多走一次for loop
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