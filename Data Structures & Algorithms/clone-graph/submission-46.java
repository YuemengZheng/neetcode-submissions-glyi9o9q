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
        // dfs with hashmap
        // for each node, if it is exist in the hashmap, return clone
        // otherwise, clone the node and recursively clone all it's neis and build the connection
        // finally return cloned node
        // tc: v + e, sc: v

        if(node == null) return null;
        Map<Node, Node> map = new HashMap<>();
        return dfs(node, map); 
    }
    private Node dfs(Node node, Map<Node, Node> map){
        if(map.containsKey(node)) return map.get(node);

        Node clone = new Node(node.val);
        map.put(node, clone);// 1
        for(Node nei : node.neighbors){ // 2
            clone.neighbors.add(dfs(nei, map));
        }

        return clone;
    }
}
// node1 = null -> null
// node2 = 1 -> 2  | 1 -> 2
// map {
// 1 -> 1,
// 2 -> 2
// }
