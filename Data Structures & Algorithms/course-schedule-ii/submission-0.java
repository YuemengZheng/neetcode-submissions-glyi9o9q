class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // 建立两个表
        int[] indegree = new int[numCourses];//还有几门先修课
        List<List<Integer>> graph = new ArrayList<>();//课程之间的关系
        for(int i = 0; i < numCourses; i++){
            graph.add(new ArrayList<>());
        }
        for(int[] pre : prerequisites){
            indegree[pre[0]]++; 
            graph.get(pre[1]).add(pre[0]);// 先 -》 后
        }

        // 将可以上的课放进queue
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }

        int finish = 0;
        int[] res = new int[numCourses];
        while(!q.isEmpty()){
            int node = q.poll();
            res[finish++] = node;
            for(int nei : graph.get(node)){
                indegree[nei]--;
                if(indegree[nei] == 0){
                    q.add(nei);
                }
            }
        }
        if(finish != numCourses){
            return new int[]{};
        }
        return res;
    }
}
