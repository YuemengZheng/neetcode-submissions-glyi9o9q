class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // This problem can be modeled as finding the shortest path in an unweighted graph 
        // where each word is a node and edges connect words that differ by exactly one character. 
        // For each word, we try replacing each character with all 26 letters. 
        // If the resulting word exists in our word set, it is a valid neighbor.
        // n^2 * m ==> n * m ^ 2

        /*
        Convert the word list to a set for O(1) lookups.
        Start BFS from beginWord with distance counter set to 0.
        For each word in the current level, generate all possible words by changing one character at a time.
        If a generated word is in the word set, add it to the queue and remove it from the set to mark as visited.
        Return the distance when endWord is found, or 0 if the queue empties.
        */

        // 剪枝
        if(!wordList.contains(endWord) || beginWord.equals(endWord)) return 0;
        Set<String> words = new HashSet<>(wordList); // list放进set
        int res = 0;
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);

        while(!q.isEmpty()){
            res++;
            // 当前层
            for(int i = q.size(); i > 0; i--){
                String node = q.poll();
                if(node.equals(endWord)) return res;
                // try to find possible word in the set 
                for(int j = 0; j < node.length(); j++){
                    for(char c = 'a'; c <= 'z'; c++){
                        if(c == node.charAt(j)) continue;
                        String nei = node.substring(0, j) + c + node.substring(j + 1);
                        if(words.contains(nei)){
                            q.offer(nei);
                            words.remove(nei); 
                        }
                    }
                }
            }
        }
        return 0;
    }
}
