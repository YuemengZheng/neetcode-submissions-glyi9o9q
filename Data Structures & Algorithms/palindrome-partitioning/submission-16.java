class Solution {
    List<List<String>> res = new ArrayList<>();
    List<String> path = new ArrayList<>();
    public List<List<String>> partition(String s) {
        /*
        aab
        a a b, aa b

        backtrack: inputs: s, start, get all the res
        base case: when the start hits the end of the s, add the path to the res
        otherwise: try to pick a subtring from the remaining string, use a helper function to check if it is a palindrome
        if true, add the substring to the path, recurse on the next start index, backtrack by remove the subtring
        tc:o(2^n * n^2)
        */
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

        backtrack(s, 0, dp);
        return res;
    }
    private void backtrack(String s, int start, boolean[][] dp) {
        if(start == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }

        for(int end = start; end < s.length(); end++) {
            String cur = s.substring(start, end + 1);
            if(dp[start][end]) {
                path.add(cur);
                backtrack(s, end + 1, dp);
                path.remove(path.size() - 1);
            }
        }
    }
    // private boolean isPalindrome(String s) {
    //     int i = 0;
    //     int j = s.length() - 1;
    //     while(i < j) {
    //         if(s.charAt(i) != s.charAt(j)) return false;
    //         i++;
    //         j--;
    //     }
    //     return true;
    // }
}

