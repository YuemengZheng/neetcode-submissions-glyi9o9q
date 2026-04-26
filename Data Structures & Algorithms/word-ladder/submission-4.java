class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        //This problem can be modeled as finding the shortest path in an unweighted graph, so we can solve it using BFS.
        // Each word is treated as a node. Two words are connected if they differ by exactly one character and exists in the list.
        // so how to find its neis,Instead of comparing every pair of words in the list, which would be too slow
        // we generate neis by changing one character at a time.
            // For each position in the word, we try replacing it with the 25 other letters.
            // If the generated word exists in the word set, it is a valid neighbor.
        // *********TC: O(n * m * m), SC: O(n * m * m)*********

        // 剪枝
        if(!wordList.contains(endWord) || beginWord.equals(endWord)) return 0;
        // convert the word list into a hash set so that we can check whether a generated word exists in O(1) time.
        Set<String> words = new HashSet<>(wordList); // list放进set
        int res = 0;
        Queue<String> q = new LinkedList<>();
        // We start BFS from beginWord
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
                            words.remove(nei); // avoid revisiting
                        }
                    }
                }
            }
        }
        return 0;
    }
}
