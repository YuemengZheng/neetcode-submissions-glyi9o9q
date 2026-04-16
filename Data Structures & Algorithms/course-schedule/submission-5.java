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
        // *********TC: O(V + E), SC: O(V + E)********* ??? 

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
        
        // use dijistra to solve this problem
        // build the graph by using prerequisites
        // use an array to keep track of the number of prerequisites of the course
        // get all the courses that have no prerequisites
        // put them into a queue
        // when we poll a couse, it means we take the course
        // so we update the indegree of the dependent courses
        // if the indegree is 0, we put the course into the queue
        // finally, if all the course can be taken return true, else return false

        // Map<Integer, List<Integer>> map = new HashMap<>();
        // int[] indegree = new int[numCourses];
        // for(int[] pair : prerequisites){
        //     if(!map.containsKey(pair[1])){
        //         map.put(pair[1], new ArrayList<>());
        //     }
        //     map.get(pair[1]).add(pair[0]);
        //     indegree[pair[0]]++;
        // }
        // Queue<Integer> q = new LinkedList<>();
        // for(int i = 0; i < numCourses; i++){
        //     if(indegree[i] == 0){
        //         q.offer(i);
        //     }
        // }

        // while(!q.isEmpty()){
        //     int cur = q.poll();
        //     numCourses--;
        //     if(!map.containsKey(cur)) continue;
        //     for(int next : map.get(cur)){
        //         indegree[next]--;
        //         if(indegree[next] == 0){
        //             q.offer(next);
        //         }
        //     }
        // }
        // return numCourses == 0;
    }
}
