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

        public int find(int a){
            if(a != parent[a]){
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
    public int[] findRedundantConnection(int[][] edges) {
        // use union find to find the last edge that causes to cycle
        UnionFind uf = new UnionFind(edges.length);
        for(int[] edge : edges){
            if(!uf.union(edge[0] - 1, edge[1] - 1)) return new int[]{edge[0], edge[1]};
        }
        return new int[]{-1, -1};
    }
}
