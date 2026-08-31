class Solution {
    public String foreignDictionary(String[] words) {
        // 要先统计出所有的letters，有些letter可能没有参与edges，但是也要出现在最终的排序！！
        // 推算出edges
        // - 不同的pair可能推算出一样的edge，要去重复
        // - 前面的string不可以比后面的短，如果他们没有differ
        // - ab, ac 只可以推算b, c的关系，a和他们的关系是待定的
        // 用edges关系做topological的计算，小心中间有环

        // initialize the letters
        Map<Character, Set<Character>> graph = new HashMap<>();
        int[] indegree = new int[26];
        Arrays.fill(indegree, -1);
        for(String word : words) {
            for(char c : word.toCharArray()) {
                graph.putIfAbsent(c, new HashSet<>());
                indegree[c - 'a'] = 0;
            }
        }

        // get the graph and indegree
        for(int i = 0; i < words.length - 1; i++){
            String w1 = words[i];
            String w2 = words[i + 1];
            int len = Math.min(w1.length(), w2.length());
            boolean find = false;
            for(int j = 0; j < len; j++) {
                if(w1.charAt(j) != w2.charAt(j)){
                    find = true;
                    if(!graph.get(w1.charAt(j)).contains(w2.charAt(j))) {
                        graph.get(w1.charAt(j)).add(w2.charAt(j));
                        indegree[w2.charAt(j) - 'a']++;
                    }
                    break;
                }
            }
            if(!find && w1.length() > w2.length()) return "";
        }
        // use the q to get the str
        StringBuilder sb = new StringBuilder();
        Queue<Character> q = new ArrayDeque<>();
        int cnt = 0;
        for(int i = 0; i < 26; i++) {
            if(indegree[i] >= 0) cnt++;
            if(indegree[i] == 0) q.offer((char)('a' + i));
        }
        while(!q.isEmpty()) {
            char cur = q.poll();
            sb.append(cur);
            cnt--;
            for(char next : graph.get(cur)) {
                if(--indegree[next - 'a'] == 0) {
                    q.offer(next);
                }
            }
        }
        return cnt == 0? sb.toString() : "";
    }
}
