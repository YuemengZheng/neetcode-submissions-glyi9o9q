class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> words = new HashSet<>(wordList);
        if(!words.contains(endWord)) return 0;
        Set<String> visited = new HashSet<>();
        int[] res = {Integer.MAX_VALUE};
        dfs(1, beginWord, endWord, words, visited, res);
        return res[0] == Integer.MAX_VALUE ? 0 : res[0];
    }
    private void dfs(int cnt, String cur, String end, Set<String> words, Set<String> visited, int[] res){
        if(cnt >= res[0]) return;
        if(cur.equals(end)){
            res[0] = cnt;
            return;
        }
        visited.add(cur);
        for(int i = 0; i < cur.length(); i++){
            for(int j = 0; j < 26; j++){
                StringBuilder sb = new StringBuilder();
                sb.append(cur.substring(0, i)).append((char)(j + 'a')).append(cur.substring(i + 1));
                String word = sb.toString();
                if(words.contains(word) && !visited.contains(word)){
                    dfs(cnt+1, word, end, words, visited, res);
                }
            }
        }
        visited.remove(cur);
    }
}