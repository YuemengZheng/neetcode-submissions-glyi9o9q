class Solution {
    List<String> res = new ArrayList<>();
    public List<String> wordBreak(String s, List<String> wordDict) {
        // each level => try to get a end point in the remaining string
        // when we hit the end of the string and all the string are in the dict, add that path to the res

        // global variables: sb to help us record the path, res to store all the valid res
        // helper function takes: s, set, startindex
        // base case: if startindex hits the end of the s, add the path to the res
        // try all the possible end point, check if the string exist in the map, if so update the string and recurse on the next index
        
        Set<String> set= getSet(wordDict);
        backtrack(s, set, 0, new StringBuilder());
        return res;
    }
    private void backtrack(String s, Set<String> set, int startIndex, StringBuilder sb) {
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
                backtrack(s, set, i + 1, sb);
                sb.setLength(len);
            }
        }
    }
    private Set<String> getSet(List<String> wordDict) {
        Set<String> set = new HashSet<>();
        for(String s : wordDict) {
            set.add(s);
        }
        return set;
    }
}