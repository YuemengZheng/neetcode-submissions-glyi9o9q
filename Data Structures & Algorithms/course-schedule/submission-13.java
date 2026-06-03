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
