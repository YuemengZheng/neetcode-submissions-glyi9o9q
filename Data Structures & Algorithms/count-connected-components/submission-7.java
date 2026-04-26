class Solution {
    public int countComponents(int n, int[][] edges) {
        // 对于每一个点我需要知道我可以用dfs可以走到哪里，将他们视为一个整体，然后把这些nodes都标记成visited
        // 当我apply dfs to all the nodes, we can get the number of connect components
        // first we need build the graph according to the edges
        // use a n sized array to record if the node has been visited
        // apply dfs to each node and get the final number of connected components
        // *********TC: O(n), SC: O(n)*********
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
