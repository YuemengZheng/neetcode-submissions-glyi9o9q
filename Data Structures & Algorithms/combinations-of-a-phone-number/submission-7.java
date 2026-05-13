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
        1. map the number with the string
        2. use backtrack to get all the letter combinations of the phone number
        3. each level handle one digit, we have some letters to choose
        4. when we reach the end of the string, collet the path
        */
        // digits = "" -> Output: [] 不然会返回[""]
        if(digits.length() == 0){
            return res;
        }
        backtrack(0, digits);
        return res;
    }
    private void backtrack(int cur, String digits){
        if(cur == digits.length()){
            res.add(path.toString());
            return;
        }

        String s = digitToString[digits.charAt(cur) - '0'];
        for(char c : s.toCharArray()){
            path.append(c);
            backtrack(cur + 1, digits);
            path.deleteCharAt(path.length() - 1);
        }
    }
}
