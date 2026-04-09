class Solution {
    public boolean validTree(int n, int[][] edges) {
        // tree: 
        // It has no cycles
        // It is fully connected
        // Using DFS, we can detect cycles by checking 
        // if we visit a node again other than its parent
        // also a tree with n nodes must have exactly n - 1 edges 
        if(edges.length > n - 1){
            return false;
        }
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        Set<Integer> visit = new HashSet<>();
        if(!dfs(0, -1, visit, graph)){
            return false;
        }
        return visit.size() == n;
    }
    private boolean dfs(int node, int parent, Set<Integer> visit, List<List<Integer>> graph){
        if(visit.contains(node)){
            return false;
        }
        visit.add(node);
        for(int nei : graph.get(node)){
            if(nei == parent) continue;
            if(!dfs(nei, node, visit, graph)){
                return false;
            }
        }
        return true;
    }
}
