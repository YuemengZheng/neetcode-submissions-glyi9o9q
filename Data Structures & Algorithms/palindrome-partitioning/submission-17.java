class Solution {
    List<List<String>> res = new ArrayList<>();
    List<String> path = new ArrayList<>();
    public List<List<String>> partition(String s) {
        /*
        I'll use backtracking. 
        At each step, I try all possible substrings from the current index. 
        If it's a palindrome, I add it to the path and recurse. 
        When I reach the end, I collect the result

        The time complexity is O(n × 2ⁿ), because there are about 2ⁿ possible partitions, 
        and for each partition we may spend O(n) time checking whether substrings are palindromes.

        The space complexity is O(n) for the recursion stack, excluding the output.
        */
        /*
        // Precompute palindrome check using DP to avoid O(n) check during backtracking
        // dp[i][j] = true if s[i...j] is a palindrome
        // if length <= 2: check s[i] == s[j]
        // otherwise: s[i] == s[j] && dp[i+1][j-1]
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        // initialize
        for(int i = n - 1; i >= 0; i--) {
            for(int j = i; j < n; j++) {
                if(s.charAt(i) == s.charAt(j)) {
                    if(j - i < 2 || dp[i + 1][j - 1]){
                        dp[i][j] = true;
                    }
                }
            }
        }
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
