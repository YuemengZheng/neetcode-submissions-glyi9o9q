class Solution {
    public int countComponents(int n, int[][] edges) {
        /*
        Build a graph from the edge list.
        For each unvisited node, increment count and apply DFS to mark all nodes in the same component as visited.
        Return count as the number of connected components.
        TC: O(v + e), for building the graph and apply the dfs to each node
        SC: O(v + e), for the graph
        */

        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        boolean[] visited = new boolean[n];
        int cnt = 0;
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                cnt++;
                dfs(i, graph, visited);
            }
        }
        return cnt;
    }
    private void dfs(int i, List<List<Integer>> graph, boolean[] visited){
        if(visited[i] == true) return;

        visited[i] = true;
        for(int next : graph.get(i)){
            dfs(next, graph, visited);
        }
    }
}
