class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        /*
        Goal:
        "Find the root nodes that minimize the height of the tree."
        High level:
        "The answer is always 1 or 2 center nodes. 
        Use topological sort — peel leaf nodes layer by layer from outside to inside until 1 or 2 nodes remain."
        Main steps:
        "Build an undirected graph and track each node's degree. 
        Add all leaf nodes (degree = 1) to the queue. Each round, 
        peel off the current leaf layer, decrement neighbors' degree. When a neighbor's degree becomes 1, it's the new leaf. Stop when remaining nodes <= 2."
        TC & SC:
        "Time complexity is O(n), each node is processed once. Space complexity is O(n) for the graph and queue."
        */
        if(n <= 2) {
            List<Integer> res = new ArrayList<>();
            for(int i = 0; i < n; i++) res.add(i);
            return res;
        }

        List<List<Integer>> graph = new ArrayList<>();
        int[] degree = new int[n];
        for(int i = 0; i < n; i++) graph.add(new ArrayList<>());
        for(int[] edge : edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
            degree[edge[0]]++;
            degree[edge[1]]++;
        }

        Deque<Integer> q = new ArrayDeque<>();
        for(int i = 0; i < n; i++){
            if(degree[i] == 1) q.offer(i);
        }

        int remain = n;
        while(remain > 2){
            int size = q.size();
            remain -= size;
            for(int i = 0; i < size; i++){
                int cur = q.poll();
                for(int next : graph.get(cur)){
                    degree[next]--;
                    if(degree[next] == 1) q.offer(next);
                }
            }
        }

        return new ArrayList<>(q);
    }
}