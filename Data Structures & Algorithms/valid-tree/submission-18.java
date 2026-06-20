class Solution {
    // class unionfind
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
        // find the root the element
        private int find(int a){
            if(parent[a] != a){
                parent[a] = find(parent[a]);
            }
            return parent[a];
        }
        // union two elements
        private boolean union(int a, int b){
            int rootA = find(a);
            int rootB = find(b);
            if(rootA == rootB) return false;
            if(size[rootA] > size[rootB]){
                parent[rootB] = rootA;
                size[rootA] += size[rootB];
            }else{
                parent[rootA] = rootB;
                size[rootB] += size[rootA];
            }
            return true;
        }
    }
    public boolean validTree(int n, int[][] edges) {
        // 1. check if the number of edges == n - 1
        // 2. use unionfind to check whether there is a cycle

        // steps:
        // corner case: if number of edges != n - 1, return false
        if(edges.length != n - 1) return false;

        // build a union find and iterate through each edge
        UnionFind uf = new UnionFind(n);
        for(int[] edge : edges){
        // if two pointers exists in the same set return false
        // otherwise union the two pointers
            if(!uf.union(edge[0], edge[1])){
                return false;
            }
        }
        // finally return true
        return true;
    }
}
