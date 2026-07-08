class Solution {
    List<String> res = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    public List<String> wordBreak(String s, List<String> wordDict) {
        /*
        High level:
        Use backtracking to find all valid word break combinations. 
        At each step, try all possible end points in the remaining string 
        and check if the substring exists in the dictionary.

        Main steps:
        I use a global StringBuilder to record the current path and a result list to store all valid combinations.
        The helper function takes the string, the dictionary set, and the start index.
        Base case: when start index hits the end of the string, add the current path to the result.
        Otherwise, try all possible end points from the start index. 
        If the substring exists in the dictionary, append it to the StringBuilder, 
        recurse on the next index, then backtrack by resetting the StringBuilder length.

        TC & SC:
        Time complexity is O(2^n * n²) because there are 2^n possible combinations, 
        and at each level we try O(n) end points, each taking O(n) for substring creation and hash computation.
        Space complexity is O(n + m) n for the recursion stack and StringBuilder， 
        m is the total characters in the dictionary for the HashSet.

        Set 查询平均是 O(1)，但这里存的是 String！
        查询 Integer/primitive → O(1)
        因为 hash 计算是 O(1)。
        查询 String → O(L)
        因为计算 String 的 hash 需要遍历每个字符，是 O(L)。然后如果 hash 碰撞还需要 equals 比较，也是 O(L)。
        所以：

        Set<Integer> 的 contains → O(1)
        Set<String> 的 contains → O(L)，L 是字符串长度
        */
        
        Set<String> set= new HashSet<>(wordDict);
        backtrack(s, set, 0);
        return res;
    }
    private void backtrack(String s, Set<String> set, int startIndex) {
        if(startIndex == s.length()) {
            res.add(sb.toString());
            return;
        }

        for(int i = startIndex; i < s.length(); i++) {
            String word = s.substring(startIndex, i + 1);
            if(set.contains(word)) {
                int len = sb.length();
                if(startIndex > 0) sb.append(' ');
                sb.append(word);
                backtrack(s, set, i + 1);
                sb.setLength(len);
            }
        }
    }
}