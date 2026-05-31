class Solution {
    List<String> res = new ArrayList<>();
    StringBuilder path = new StringBuilder();
    public List<String> generateParenthesis(int n) {
        // use backtracking to get valid strings
        // at each step, we pick one kind of parentheses, left or right
        // then recurse, when the size of the path reaches 2 * n, collect the result
        backtrack(n, n);
        return res;
    }
    private void backtrack(int leftRemain, int rightRemain){
        if(leftRemain == 0 && rightRemain == 0){
            res.add(path.toString());
            return;
        }

        if(leftRemain > 0){
            path.append("(");
            backtrack(leftRemain - 1, rightRemain);
            path.deleteCharAt(path.length() - 1);
        }

        if(rightRemain > leftRemain){
            path.append(")");
            backtrack(leftRemain, rightRemain - 1);
            path.deleteCharAt(path.length() - 1);
        }
    }
}
