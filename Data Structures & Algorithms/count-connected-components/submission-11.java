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
    public int countComponents(int n, int[][] edges) {
        // 使用union find计算我们有几个union
        // 一开始我们有n个union，每union一次我们cnt--，最终的cnt就是答案
        int cnt = n;
        UnionFind uf = new UnionFind(n);
        for(int[] edge : edges){
            if(uf.union(edge[0], edge[1])) cnt--;
        }
        return cnt;
    }
}
