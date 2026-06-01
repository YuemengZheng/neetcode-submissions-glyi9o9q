/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        /*
        I'll use DFS with a hashmap to map original nodes to their clones. 
        For each node, if it's already cloned, return it directly. 
        Otherwise, create a clone, then recursively clone all its neighbors.
        
        Time is O(V + E) since we visit each node and edge once. 
        Space is O(V) for the hashmap and recursion stack.
        */
        if(node == null) return null; // 因为node的数量可以为0，需要写base case
        Map<Node, Node> map = new HashMap<>();
        return dfs(node, map);
    }
    private Node dfs(Node node, Map<Node, Node> map){
        if(map.containsKey(node)){
            return map.get(node);
        }

        Node clone = new Node(node.val);// initialize
        map.put(node, clone);
        for(Node nei : node.neighbors){
            clone.neighbors.add(dfs(nei, map));// 收集
        }
        return clone;// return
    }
}