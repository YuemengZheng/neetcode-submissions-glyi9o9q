class Solution {
    List<String> res = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    public List<String> generateParenthesis(int n) {
        backtrack(0, 0, n);
        return res;
    }
    private void backtrack(int leftUsed, int rightUsed, int n){
        if(leftUsed == rightUsed && leftUsed == n){
            res.add(sb.toString());
            return;
        }

        if(leftUsed < n){
            sb.append('(');
            backtrack(leftUsed + 1, rightUsed, n);
            sb.deleteCharAt(sb.length() - 1);
        }

        if(rightUsed < leftUsed){
            sb.append(')');
            backtrack(leftUsed, rightUsed + 1, n);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
