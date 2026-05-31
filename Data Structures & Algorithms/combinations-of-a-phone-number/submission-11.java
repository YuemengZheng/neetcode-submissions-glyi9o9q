class Solution {
    String[] digitToString = new String[]{
        null,
        null,
        "abc",
        "def",
        "ghi",
        "jkl",
        "mno",
        "pqrs",
        "tuv",
        "wxyz"
    };
    List<String> res = new ArrayList<>();
    StringBuilder path = new StringBuilder();
    public List<String> letterCombinations(String digits) {
        /*
        I'll use backtracking. 
        At each level, I map the current digit to its corresponding letters and try each one.
        When path size equals digits length, collect the result.

        Time is O(4^n) since each digit maps to at most 4 letters. Space is O(n) for the recursion stack.

        因为 input “”的时候返回是[] 所以我们务必要提前返回 
        如果""返回[""]，那base case index == digits.返回[""]，
        那base case index == digits.length()就会直接触发，收集空string，不需要提前return
        */
        if(digits.length() == 0) return res; 
        backtrack(0, digits);
        return res;
    }
    private void backtrack(int index, String digits){
        if(index == digits.length()){
            res.add(path.toString());
            return;
        }

        String s = digitToString[digits.charAt(index) - '0']; // 需要把char转换为int使用
        for(char c : s.toCharArray()){
            path.append(c);
            backtrack(index + 1, digits);
            path.deleteCharAt(path.length() - 1);
        }
    }
}
