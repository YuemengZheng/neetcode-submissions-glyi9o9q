class Solution {
    public int countComponents(int n, int[][] edges) {
        // using dfs
        // build a graph
        // maintain a array to track visited nodes
        // for each unvisited node:
        // run dfs from this node
        // increase res by 1
        // *********TC: O(E + V), SC: O(E + V)*********
        // 创建graph,e + v
        // 遍历node =》 e， 扫描边 =〉 v

        List<List<Integer>> graph = new ArrayList<>();
        boolean[] visit = new boolean[n];
        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        int res = 0;
        for(int node = 0; node < n; node++){
            if(!visit[node]){
                dfs(graph, visit, node);
                res++;
            }
        }
        return res;
    }
    private void dfs(List<List<Integer>> graph, boolean[] visit, int node){
        if(visit[node]) return;
        visit[node] = true;
        for(int nei : graph.get(node)){
            dfs(graph, visit, nei);
        }
    }
}
