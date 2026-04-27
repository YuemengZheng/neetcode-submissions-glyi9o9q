class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        /*
        This problem can be modeled as finding the shortest path in a graph, so we use BFS.
        Each word is treated as a node. Two words are connected if they differ by exactly one character.
        We use a set to store all words for fast lookup.

        We perform BFS starting from beginWord.
        For each word, we generate its neighbors by changing one character at a time:
            - For each position, we try replacing it with all other 25 lowercase letters.
            - If the generated word exists in the set, it is a valid neighbor.
        When we reach endWord, we return the current path length.
        If endWord is not in the word list, we return 0.
        */
        // *********TC: O(n * m * m), SC: O(n * m * m)*********


        // // 剪枝
        // if(!wordList.contains(endWord) || beginWord.equals(endWord)) return 0;
        // // convert the word list into a hash set so that we can check whether a generated word exists in O(1) time.
        // Set<String> words = new HashSet<>(wordList); // list放进set
        // int res = 0;
        // Queue<String> q = new LinkedList<>();
        // // We start BFS from beginWord
        // q.offer(beginWord);

        // while(!q.isEmpty()){
        //     res++;
        //     // 当前层
        //     for(int i = q.size(); i > 0; i--){
        //         String node = q.poll();
        //         if(node.equals(endWord)) return res;
        //         // try to find possible word in the set 
        //         for(int j = 0; j < node.length(); j++){
        //             for(char c = 'a'; c <= 'z'; c++){
        //                 if(c == node.charAt(j)) continue;
        //                 String nei = node.substring(0, j) + c + node.substring(j + 1);
        //                 if(words.contains(nei)){
        //                     q.offer(nei);
        //                     words.remove(nei); // avoid revisiting
        //                 }
        //             }
        //         }
        //     }
        // }
        // return 0;

        Set<String> set = new HashSet<>(wordList);
        if(!set.contains(endWord) || beginWord == endWord){
            return 0;
        }

        int res = 0;
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);

        while(!q.isEmpty()){
            int size = q.size();
            res++;
            for(int i = 0; i < size; i++){
                String cur = q.poll();
                if(cur.equals(endWord)){
                    return res;
                }
                // replace each letter with 26 letters
                // check if exist in the set
                for(int j = 0; j < cur.length(); j++){
                    for(char c = 'a'; c <= 'z'; c++){
                        if(c == cur.charAt(j)) continue;
                        String nei = cur.substring(0, j) + c + cur.substring(j + 1);
                        if(set.contains(nei)){
                            q.offer(nei);
                            set.remove(nei);
                        }
                    }
                }
            }
        }
        return 0;
    }
}
