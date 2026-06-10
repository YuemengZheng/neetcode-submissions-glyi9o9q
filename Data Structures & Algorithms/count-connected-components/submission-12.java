class Solution {
    /*
    solution2: union find
    Initialize count as n, treating each node as its own component.
    For each edge, union the two nodes. If they were in different components, decrement count.
    Return count as the number of connected components.

    TC: O(n + e), SC: O(n)

    */
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
    public int countComponents(int n, int[][] edges) {
        int cnt = n;
        UnionFind uf = new UnionFind(n);
        for(int[] edge : edges){
            if(uf.union(edge[0], edge[1])) cnt--;
        }
        return cnt;
    }
}
