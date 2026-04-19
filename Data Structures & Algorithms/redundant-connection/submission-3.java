class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        // 我们在找the first edge (u, v) where both endpoints are in cycle
        // Since the graph was originally a tree, adding one extra edge must create exactly one cycle.
        // We use Union Find to track connectivity.
        // If two nodes of an edge are already connected, adding this edge forms a cycle, so that edge is the redundant connection.


        // Initialize a Union Find structure where each node is its own parent.
        int n = edges.length;
        int[] parent = new int[n + 1];
        for(int i = 0; i <= n; i++){
            parent[i] = i;
        }

        // Iterate through each edge (u, v) in edges
        // Find the root of u and v using find().
        // If both nodes have the same root, adding this edge creates a cycle, so return this edge.
        // Otherwise, union them
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];

            int pu = find(parent, u);
            int pv = find(parent, v);

            if (pu == pv) return edge;

            parent[pv] = pu;
        }

        return new int[]{-1, -1};
    }

    private int find(int[] parent, int x) {
        // Path compression flattens the structure of the tree during find operations.
        if(parent[x] != x){
            parent[x] = find(parent, parent[x]);
        }
        return parent[x];
    }
}
   
