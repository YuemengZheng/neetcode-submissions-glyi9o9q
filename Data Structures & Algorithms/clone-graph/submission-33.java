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
        // use dfs 
        // map the original node to the cloned node
        // for each node, if it is already created, get the node in the map
        // otherwise, create the node and recurse on its neighbors and build the connection
        if(node == null) return null;
        Map<Node, Node> map = new HashMap<>();
        return dfs(node, map);
    }
    private Node dfs(Node node, Map<Node, Node> map){
        if(map.containsKey(node)) return map.get(node);
        Node clone = new Node(node.val);
        map.put(node, clone);
        for(Node next : node.neighbors){
            clone.neighbors.add(dfs(next, map));
        }
        return clone;
    }
}