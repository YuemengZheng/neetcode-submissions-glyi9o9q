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
        // map the original node and the cloned node to avoid duplication
        // use dfs to first check whether the node has been created, if so, use that node, else create a cloned node
        // recurse on it's neighbors and build the connection
        if(node == null) return null;
        Map<Node, Node> map = new HashMap<>();
        Node start = node;
        dfs(start, map);
        return map.get(node);
    }
    private Node dfs(Node node, Map<Node, Node> map){
        if(map.containsKey(node)){
            return map.get(node);
        }

        Node clone = new Node(node.val);
        map.put(node, clone);
        for(Node nei : node.neighbors){
            clone.neighbors.add(dfs(nei, map));
        }
        return clone;
    }
}