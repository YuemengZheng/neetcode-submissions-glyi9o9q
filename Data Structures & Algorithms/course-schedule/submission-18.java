class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // build graph
        // build indegree
        // get all the ready couse
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int i = 0; i < numCourses; i++) {
            graph.put(i, new ArrayList<>());
        }
        int[] indegree = new int[numCourses];
        for(int[] pair : prerequisites) {
            indegree[pair[0]]++;
            graph.get(pair[1]).add(pair[0]);
        }
        Queue<Integer> q = new ArrayDeque<>();
        for(int i = 0; i < numCourses; i++) {
            if(indegree[i] == 0) {
                q.offer(i);
            }
        }
        int cnt = 0;
        while(!q.isEmpty()) {
            int cur = q.poll();
            cnt++;
            for(int next : graph.get(cur)) {
                if(--indegree[next] == 0) q.offer(next);
            }
        }
        return cnt == numCourses;
    }
}
