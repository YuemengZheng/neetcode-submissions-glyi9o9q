class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // bfs
        // find the shortest path of transforming the beginword to endword
        // for each word in the queue, explore by change one position with other letters at a time
        // if the explored word exist in the list, put in the queue and repeat the same process until we find the endword
        // use a hashmap to store all the words
        // corner case if map does not contain the endWord, return 0;
        // otherwise, initialize the queue, and a set to store all the visited word
        // put the beginword in the queue and update the visited word
        // set steps as 1
        // enter the while loop
        // first get the size of the queue and while loop exactly that times, update the steps
        // poll out the word and check if it is the endword, if so return steps
        // otherwise explore by replacing one position at a time
        // if it is in the map and has not been visited, put int the queue
        Set<String> words = new HashSet<>(wordList);
        if(!words.contains(endWord)) return 0;

        Set<String> visited = new HashSet<>();
        Queue<String> q = new ArrayDeque<>();
        q.offer(beginWord);
        visited.add(beginWord);
        int steps = 1;
        while(!q.isEmpty()){
            int size = q.size();
            steps++;
            while(size > 0){
                String cur = q.poll();
                size--;
                for(int i = 0; i < cur.length(); i++){
                    for(int j = 0; j < 26; j++){
                        StringBuilder sb = new StringBuilder();
                        sb.append(cur.substring(0, i)).append((char)(j + 'a')).append(cur.substring(i + 1));
                        String next = sb.toString();
                        if(next.equals(endWord)) return steps;
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
