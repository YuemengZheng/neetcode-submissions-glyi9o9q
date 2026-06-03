class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] indegree = new int[numCourses];
        for(int[] pair : prerequisites){
            indegree[pair[0]]++;
            graph.computeIfAbsent(pair[1], k -> new ArrayList<>()).add(pair[0]);
        }

        Queue<Integer> q = new ArrayDeque<>();
        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0){
                q.offer(i);
            }
        }

        int[] res = new int[numCourses];
        int index = 0;
        while(!q.isEmpty()){
            int cur = q.poll();
            res[index++] = cur;
            if(!graph.containsKey(cur)) continue;
            for(int nei : graph.get(cur)){
                indegree[nei]--;
                if(indegree[nei] == 0){
                    q.offer(nei);
                }
            }
        }
        return index == numCourses ? res : new int[]{};
    }
}
