class Solution {
    class UnionFind{
        int[] parent;
        int[] size;

        public UnionFind(int n){
            parent = new int[n];
            size = new int[n];
            
            for(int i = 0; i < n; i++){
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int find(int x){
            if(parent[x] != x){
                parent[x] = find(parent[x]); 
            }
            return parent[x];
        }

        public void union(int a, int b){
            int rootA = find(a);
            int rootB = find(b);

            if(rootA == rootB) return;

            if(size[rootA] < size[rootB]){
                parent[rootA] = rootB;
                size[rootB] += size[rootA];
            }else{
                parent[rootB] = rootA;
                size[rootA] += size[rootB];
            }
        }
    }
    public boolean validTree(int n, int[][] edges) {
        // A valid tree must have exactly n - 1 edges and contain no cycles.
        // We use Union Find to detect cycles.

        // 1. Initialize Union Find, treating each node as its own set.
        // 2. Iterate through each edge:
            // - If the two nodes are already in the same set, it means there is a cycle, so return false.
            // - Otherwise, union the two nodes.
        // 3. If all edges are processed without detecting a cycle, return true.
        if(edges.length != n - 1) return false;

        UnionFind uf = new UnionFind(n);

        for(int[] edge : edges){
            int a = edge[0];
            int b = edge[1];

            if(uf.find(a) == uf.find(b)) return false;

            uf.union(a, b);
        }

        return true;
    }
}
