class Solution {
    class UnionFind {
        int[] parent;
        int[] size;
        public UnionFind(int n) {
            parent = new int[n];
            size = new int[n];
            for(int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
            
        }

        public int find(int a) {
            if(a != parent[a]) {
                parent[a] = find(parent[a]);
            }
            return parent[a];
        }

        public boolean union(int a, int b) {
            int rootA = find(a);
            int rootB = find(b);
            if(rootA == rootB) return false;
            
            if(size[rootA] <= size[rootB]) {
                parent[rootA] = rootB;
                size[rootB] += size[rootA];
            }else {
                parent[rootB] = rootA;
                size[rootA] += size[rootB];
            }
            return true;
        }
    }
    public boolean validTree(int n, int[][] edges) {
        if(edges.length != n - 1) return false;
        UnionFind uf = new UnionFind(n);
        for(int[] e : edges) {
            if(!uf.union(e[0], e[1])) return false;
        }
        return true;
    }
}
