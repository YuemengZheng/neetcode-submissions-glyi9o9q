class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        /*
        I'll use BFS to find the shortest transformation sequence. 
        For each word, I replace one character at a time and try all 26 letters 
        If the new word is in the word list and hasn't been visited, I add it to the queue. 
        The first time I reach the endWord, that's the shortest path.

        First I check if endWord is in the word list, if not return 0. 
        Then I initialize a queue and a visited set with beginWord. 
        For each level of BFS, I increment the count. 
        For each word in the queue, I try all possible one-character transformations. 
        If I find endWord, return the count. 
        If the transformed word is in the list and not visited, add it to the queue.
        */

        Set<String> words = new HashSet<>(wordList);
        if(!words.contains(endWord)) return 0;

        Queue<String> q = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();
        q.offer(beginWord);
        int cnt = 1;

        while(!q.isEmpty()){
            int size = q.size();
            cnt++;
            while(size > 0){
                String cur = q.poll();
                size--;
                for(int i = 0; i < cur.length(); i++){
                    for(int j = 0; j < 26; j++){
                        StringBuilder sb = new StringBuilder();
                        sb.append(cur.substring(0, i)).append((char)(j + 'a')).append(cur.substring(i + 1));
                        String next = sb.toString();
                        if(next.equals(endWord)) return cnt;
                        if(words.contains(next) && !visited.contains(next)){
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
