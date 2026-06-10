class Solution {
    public int countComponents(int n, int[][] edges) {
        // use dfs
        // build the graph 
        // for each node, if it is unvisited increment the cnt, apply dfs to it
        // finally return cnt

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
