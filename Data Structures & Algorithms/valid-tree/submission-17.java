class Solution {
    class UnionFind{
        int[] parent;
        int[] size;
        public UnionFind(int n){
            parent = new int[n];
            size = new int[n];
            // 记得initialize 
            for(int i = 0; i < n; i++){
                parent[i] = i;
                size[i] = 1;
            }
        }
        public int find(int a){
            if(parent[a] != a){
                parent[a] = find(parent[a]);
            }
            return parent[a];
        }
        public boolean union(int a, int b){
            int rootA = find(a);
            int rootB = find(b);
            if(rootA == rootB) return false;
            if(size[rootA] < size[rootB]){
                parent[rootA] = rootB;
                size[rootB] += size[rootA];
            }else{
                parent[rootB] = rootA;
                size[rootA] += size[rootB];
            }
            return true;
        }
    }
    public boolean validTree(int n, int[][] edges) {
        // it has exactly n - 1 edges
        // it has no cycle
        // use unionfind to slove this problem
        UnionFind uf = new UnionFind(n);

        if(edges.length != n - 1){
            return false;
        }

        for(int[] edge : edges){
            int a = edge[0];
            int b = edge[1];
            if(!uf.union(a, b)) return false;
        }
        return true;
    }
}
