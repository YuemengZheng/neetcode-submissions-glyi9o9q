class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> list = new HashSet<>(wordList);
        if(!list.contains(endWord)) return 0;

        Set<String> visited = new HashSet<>();
        Queue<String> q = new ArrayDeque<>();
        q.offer(beginWord);
        visited.add(beginWord);
        int cnt = 1;
        while(!q.isEmpty()){
            int size = q.size();
            cnt++;
            for(int k = 0; k < size; k++){
                String cur = q.poll();
                for(int i = 0; i < cur.length(); i++){
                    for(int j = 0; j < 26; j++){
                        StringBuilder sb = new StringBuilder();
                        sb.append(cur.substring(0, i)).append((char)(j + 'a')).append(cur.substring(i + 1));
                        String next = sb.toString();
                        if(next.equals(endWord)){
                            return cnt;
                        }
                        if(list.contains(next) && !visited.contains(next)){
                            q.offer(next);
                            visited.add(next);
                        }
                    }
                }
            }
        }
        return 0;
    }
}
