class Solution {
    List<List<String>> res = new ArrayList<>();
    List<String> path = new ArrayList<>();
    public List<List<String>> partition(String s) {
        /*
        use backtracking to get all the possible lists of palindromic substrings
        each level in the recursion tree, get a valid substring
        for each level, try all the possile subtring starting from the start index
        if this substring is a parlindrome, recurse on the rest of the string
        when we reach the end of the string, collect the subtrings as one of the solution
        finally return all the solutions
        */
        backtrack(0, s);
        return res;
    }
    private void backtrack(int start, String s){
        if(start == s.length()){
            res.add(new ArrayList<>(path));
            return;
        }

        for(int end = start; end <s.length(); end++){
            if(isValid(start, end, s)){
                String part = s.substring(start, end + 1);
                path.add(part);
                backtrack(end + 1, s);
                path.remove(path.size() - 1);
            }
        }
    }
    private boolean isValid(int i, int j, String s){
        while(i < j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
