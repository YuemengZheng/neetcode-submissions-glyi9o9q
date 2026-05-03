class Solution {
    List<List<String>> res = new ArrayList<>();
    List<String> path = new ArrayList<>();
    public List<List<String>> partition(String s) {
        /*
        We use backtracking to partition the string into palindromic substrings.
        At each step, we try every possible substring starting from the current index.
        If a substring is a palindrome, we add it to the path and recurse on the rest of the string.
        When we reach the end of the string, we collect the current partition.

        The time complexity is O(n × 2ⁿ), because there are about 2ⁿ possible partitions, 
        and for each partition we may spend O(n) time checking whether substrings are palindromes.

        The space complexity is O(n) for the recursion stack and path, excluding the output.
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
