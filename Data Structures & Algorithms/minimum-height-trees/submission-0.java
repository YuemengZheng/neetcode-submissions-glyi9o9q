class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        // 通过拓扑排序，从叶子节点出发，找到最中心的1个或者2个nodes
        List<Integer> res = new ArrayList<>();
        if(n <= 2) {
            for(int i = 0; i < n; i++) {
                res.add(i);
            }
            return res;
        }
        
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] degree = new int[n];

        for(int i = 0; i < n; i++) {
            map.put(i, new ArrayList<>());
        }
        for(int[] edge : edges){
            map.get(edge[1]).add(edge[0]);
            map.get(edge[0]).add(edge[1]);
            degree[edge[1]]++;
            degree[edge[0]]++;
        }

        Deque<Integer> q = new ArrayDeque<>();
        for(int i = 0; i < degree.length; i++) {
            if(degree[i] == 1) {
                q.offer(i);
            }
        }

        int remain = n;
        while(!q.isEmpty()) {
            int level = q.size();
            for(int i = 0; i < level; i++) {
                int cur = q.poll();
                remain--;
                degree[cur]--;
                for(int next : map.get(cur)) {
                    degree[next]--;
                    if(degree[next] == 1) {
                        q.offer(next);
                    }
                }
            }
            // when to collect the answer!!
            if(remain <= 2) {
                break;
            }
        }
        while(!q.isEmpty()) {
            res.add(q.poll());
        }
        return res;
    }
}