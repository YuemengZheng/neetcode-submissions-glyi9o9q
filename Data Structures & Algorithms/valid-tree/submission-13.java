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
            // find the root of the node
            // path compression
            if(a != parent[a]){
                parent[a] = find(parent[a]);
            }
            return parent[a];
        }

        // 合并都是基于根节点
        public void union(int a, int b){
            int rootA = find(a);
            int rootB = find(b);
            if(rootA == rootB) return;

            if(size[a] < size[b]){
                parent[rootA] = rootB;
                size[rootB] += size[rootA];
            }else{
                parent[rootB] = rootA;
                size[rootA] += size[rootB];
            }
        }
    }
    public boolean validTree(int n, int[][] edges) {
        // if the tree is valid, it must has n - 1 edges and do not has cycle
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
