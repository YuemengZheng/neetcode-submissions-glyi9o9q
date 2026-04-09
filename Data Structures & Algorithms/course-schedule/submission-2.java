class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // BFS
        // prerequisite course → dependent course（入度）
        // Build a graph and compute indegree (number of prerequisites) for each course
        // Add all courses with indegree = 0 into a queue
        // Reduce the indegree of its dependent courses
        // If any dependent course reaches indegree = 0, add it to the queue
        // If finished courses == total courses - return true
        // Else - return false
        int[] indegree = new int[numCourses];
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < numCourses; i++){
            graph.add(new ArrayList<>());
        }
        for(int[] pre : prerequisites){
            indegree[pre[0]]++;
            graph.get(pre[1]).add(pre[0]);
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        int finish = 0;
        while(!q.isEmpty()){
            int node = q.poll();
            finish++;
            for(int nei : graph.get(node)){
                indegree[nei]--;
                if(indegree[nei] == 0){
                    q.add(nei);
                }
            }
        }
        return finish == numCourses;
    }
}
