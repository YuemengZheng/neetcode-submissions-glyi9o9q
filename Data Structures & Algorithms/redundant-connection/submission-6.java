class Solution {
    class UnionFind{
        int[] parent;
        int[] size;

        public UnionFind(int n){
            parent = new int[n + 1];
            size = new int[n + 1];

            for(int i = 1; i<= n; i++){
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int find(int x){
            if(x != parent[x]){
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public void union(int rootA, int rootB){
            if(size[rootA] < size[rootB]){
                parent[rootA] = rootB;
                size[rootB] += size[rootA];
            }else{
                parent[rootB] = rootA;
                size[rootA] += size[rootB];
            }
        }
    }
    public int[] findRedundantConnection(int[][] edges) {
        // use union find to find the first edge that creates the cycle

        // treat each node as a set
        // loop through each edegs
        // if two nodes already existes in the same set, this will cause the cycle return that edge
        // else union the two sets

        UnionFind uf = new UnionFind(edges.length);
        for(int[] edge : edges){
            int a = edge[0];
            int b = edge[1];
            int rootA = uf.find(a);
            int rootB = uf.find(b);

            if(rootA == rootB){
                return new int[]{a, b};
            }

            uf.union(rootA, rootB);
        }
        return new int[]{-1, -1};
    }
}
   
