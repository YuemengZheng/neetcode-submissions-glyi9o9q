class Solution {
    /*
    For a valid tree, it must have exactly n-1 edges and no cycles.
    So first I check the number of edges.
    Then I use Union Find to detect if there are any cycles.

    Union by size: keeps the tree shallow from the start.
    Path compression: every time you call find(), all nodes along the path 
    get attached directly to the root — so future lookups on those nodes cost O(1).

    TC: O(n + e), where n is for initializing the parent and size arrays, 
    and e is for processing each edge, since each union/find operation costs amortized O(1) 
    with path compression and union by size.

    SC: O(n) due to parent and size arrays
    */

    class UnionFind{
        int parent[];
        int size[];

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
    
    
    
    public boolean validTree(int n, int[][] edges) {
        // A valid tree must have exactly n - 1 edges and contain no cycles.
        // We use Union Find to detect cycles.

        // 1. Initialize Union Find, treating each node as its own set.
        // 2. Iterate through each edge:
            // - If the two nodes are already in the same set, it means there is a cycle, so return false.
            // - Otherwise, union the two nodes.
        // 3. If all edges are processed without detecting a cycle, return true.

        /*
        Time complexity is O(V + E). We initialize Union Find in O(V), 
        then process each edge once. Since find and union are nearly O(1) 
        amortized with path compression and union by size, edge processing is effectively O(E). 
        Because in a valid tree E = V - 1, we can also simplify it to O(V).
        */ 

        if(edges.length != n - 1) return false;
        UnionFind uf = new UnionFind(n);
        for(int[] edge : edges){
            if(!uf.union(edge[0], edge[1])) return false;
        }
        return true;
    }
}
