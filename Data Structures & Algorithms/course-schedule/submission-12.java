class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // build the graph based on prerequisites
        // use indegree to record the number of prerequisites each course need to take
        // then use dijis to check if we can take all the couses
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] indegree = new int[numCourses];
        for(int[] pair : prerequisites){
            int cur = pair[0];
            int pre = pair[1];
            graph.computeIfAbsent(pre, k -> new ArrayList<>()).add(cur);
            indegree[cur]++;
        }
        Queue<Integer> q = new ArrayDeque<>();
        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        int cnt = numCourses;
        while(!q.isEmpty()){
            int curCourse = q.poll();
            cnt--;
            if(!graph.containsKey(curCourse)) continue;
            for(int nei : graph.get(curCourse)){
                indegree[nei]--;
                if(indegree[nei] == 0){
                    q.offer(nei);
                }
            }
        }
        return cnt == 0;
    }
}
