class Solution {
    public boolean validTree(int n, int[][] edges) {
        // tree: 
        // It has no cycles
        // It is fully connected
        // Using DFS, we can detect cycles by checking 
        // if we visit a node again other than its parent
        // also a tree with n nodes must have exactly n - 1 edges 

        // 树有n个节点，n-1个边，快速剪枝(> n - 1 → 一定有环 < n - 1 → 一定不连通)
        if(edges.length != n - 1){
            return false;
        }
        // edges.length == n - 1 可能有环
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            //无向图？？？
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        Set<Integer> visit = new HashSet<>();
        if(!dfs(0, -1, visit, graph)){
            return false;
        }
        // 图是连通的没有懂为什么还要增加这个？？？
        return visit.size() == n;
    }
    private boolean dfs(int node, int parent, Set<Integer> visit, List<List<Integer>> graph){
        if(visit.contains(node)){
            return false;
        }
        visit.add(node);
        for(int nei : graph.get(node)){
            // special case 处理 parent，防止误认为是cycle
            if(nei == parent) continue;
            if(!dfs(nei, node, visit, graph)){
                return false;
            }
        }
        return true;
    }
}
