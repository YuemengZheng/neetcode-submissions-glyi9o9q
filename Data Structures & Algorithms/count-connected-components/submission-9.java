class Solution {
    public int countComponents(int n, int[][] edges) {
        /*
        We build an adjacency list from the edge list.
        Then apply dfs to each nodes
        For each unvisited node, we start a new DFS and increment the component count.
        Finally, the count is the number of connected components.
        */
        // *********TC: O(v + e), SC: O(v + e)*********
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];
        int res = 0;

        for(int i = 0; i < n; i++){
            if(visited[i] == false){
                res++;
                dfs(i, visited, graph);
            }
        }

        return res;
    }
    private void dfs(int node, boolean[] visited, List<List<Integer>> graph){
        visited[node] = true;
        for(int next : graph.get(node)){
            if(visited[next] == false){
                dfs(next, visited, graph);
            }
        }
    }
}
