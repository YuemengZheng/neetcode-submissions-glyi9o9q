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
        // base case
        // 如果输入是null
        if(node == null){
            return null;
        }
        // 如果已经有node了，说明我们已经处理过它，不用继续往下，返回new node
        // 防止无限递归
        if(oldToNew.containsKey(node)){
            return oldToNew.get(node);
        }

        Node copy = new Node(node.val);
        oldToNew.put(node, copy);
        
        for(Node nei : node.neighbors){
            copy.neighbors.add(dfs(nei, oldToNew));
        }
        return copy;
    }
}