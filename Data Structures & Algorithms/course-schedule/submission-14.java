class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        /*
        有依赖关系、有顺序要求、需要检测环" → 想到topological sort
        I'll use topological sort. 
        Build a graph from prerequisites and track each course's indegree. 
        Start BFS from courses with indegree 0, and keep reducing neighbors' indegree. 
        If all courses are processed, return true, otherwise there's a cycle.
        */

        // *********TC: O(V + E), SC: O(V + E)********* 

        int[] indegree = new int[numCourses];
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int[] pair : prerequisites){
            indegree[pair[0]]++;
            graph.computeIfAbsent(pair[1], k -> new ArrayList<>()).add(pair[0]);
        }
        Queue<Integer> q = new ArrayDeque<>();
        for(int i = 0;i < numCourses; i++){
            if(indegree[i] == 0){
                q.offer(i);
            }
        }
        int cnt = 0;
        while(!q.isEmpty()){
            int cur = q.poll();
            cnt++;
            if(!graph.containsKey(cur)) continue;
            for(int nei : graph.get(cur)){
                indegree[nei]--;
                if(indegree[nei] == 0){
                    q.offer(nei);
                }
            }
        }
        return cnt == numCourses;
    }
}
