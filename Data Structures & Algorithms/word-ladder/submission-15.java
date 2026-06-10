class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // use bfs
        // TC: O(m * n² * 26) = O(m * n²), SC: O(m * n)
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
            for(int i = 0; i < size; i++){
                String cur = q.poll();
                for(int j = 0; j < cur.length(); j++){
                    for(int l = 0; l < 26; l++){
                        StringBuilder sb = new StringBuilder();
                        sb.append(cur.substring(0, j)).append((char)(l + 'a')).append(cur.substring(j + 1));
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
