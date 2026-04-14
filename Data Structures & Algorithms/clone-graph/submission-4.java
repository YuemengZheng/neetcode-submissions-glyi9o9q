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
        // We use DFS to traverse the graph 
        // and a HashMap to store the mapping between the original node and the cloned node.
        // The HashMap helps us avoid recreating nodes and prevents infinite loops caused by cycles in the graph.
        // During DFS, when we encounter a node:
        // If it has already been cloned, we simply return that node
        // Otherwise, we create a new node, store it in the map, and recursively clone all its neighbors.
        Map<Node, Node> oldToNew = new HashMap<>();
        return dfs(node, oldToNew);
    }
    private Node dfs(Node node, Map<Node, Node> oldToNew){
        if(node == null) return null;
        if(oldToNew.containsKey(node)){
            return oldToNew.get(node);
        }

        Node newNode = new Node(node.val);
        newNode.neighbors = new ArrayList<>();
        oldToNew.put(node, newNode);
        for(Node child : node.neighbors){
            newNode.neighbors.add(dfs(child, oldToNew));
        }
        return newNode; 
    }
}