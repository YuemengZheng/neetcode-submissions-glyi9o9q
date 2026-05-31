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
        if(digits.length() == 0) return res;
        backtrack(0, digits);
        return res;
    }
    private void backtrack(int index, String digits){
        if(index == digits.length()){
            res.add(path.toString());
            return;
        }

        String s = digitToString[digits.charAt(index) - '0']; // 
        for(char c : s.toCharArray()){
            path.append(c);
            backtrack(index + 1, digits);
            path.deleteCharAt(path.length() - 1);
        }
    }
}
