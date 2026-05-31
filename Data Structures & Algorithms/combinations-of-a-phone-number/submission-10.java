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
        if(digits.length() == 0) return res; // 因为 input “”的时候返回是[] 所以我们务必要提前返回
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
