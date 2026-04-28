class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // build the graph
        // build the indegree array
        // put the courses with no prerequisites into the queue
        // poll a course and update the indegree of its dependent courses
        // finally if all the courses have been arrange, return list of courses
        // else return empty array
        List<List<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[numCourses];
        for(int i = 0; i < numCourses; i++){
            graph.add(new ArrayList<>());
        }
        for(int[] pair : prerequisites){
            graph.get(pair[1]).add(pair[0]);
            indegree[pair[0]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0){
                q.offer(i);
            }
        }
        int cnt = 0;
        int[] res = new int[numCourses];
        while(!q.isEmpty()){
            int cur = q.poll();
            res[cnt++] = cur;
            for(int next : graph.get(cur)){
                indegree[next]--;
                if(indegree[next] == 0){
                    q.offer(next);
                }
            }
        }
        return cnt == numCourses ? res : new int[]{};
    }
}
