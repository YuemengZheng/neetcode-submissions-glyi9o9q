class Solution {
    int res = Integer.MAX_VALUE;
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> list = new HashSet<>(wordList);
        if(!list.contains(endWord)) return 0;

        Set<String> visited = new HashSet<>();
        dfs(1, beginWord, endWord, list, visited);
        return res == Integer.MAX_VALUE ? 0 : res;
    }
    private void dfs(int cnt, String curWord, String endWord, Set<String> list, Set<String> visited){
        if(cnt >= res) return;
        if(curWord.equals(endWord)){
            res = cnt;
            return;
        }
        visited.add(curWord);
        for(int i = 0; i < curWord.length(); i++){
            for(int j = 0; j < 26; j++){
                StringBuilder sb = new StringBuilder();
                sb.append(curWord.substring(0, i)).append((char)(j + 'a')).append(curWord.substring(i + 1));
                String next = sb.toString();
                if(list.contains(next) && !visited.contains(next)){
                    dfs(cnt + 1, next, endWord, list, visited);
                }
            }
        }
        visited.remove(curWord);
    }
}
