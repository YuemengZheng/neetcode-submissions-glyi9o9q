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
        // dfs and hashmap to solve this problem
        // dfs 带我们遍历node，建立关联，hashmap带我们储存新旧node
        // 我们只要dfs graph，当遇到一个node，首先看在不在hashmap里面
        // 如果在，直接用，如果不在创建新的node，并且放入hashmap
        // 然后创建node和neighbors的关系
        Map<Node, Node> oldToNew = new HashMap<>();
        return dfs(node, oldToNew);
    }
    private Node dfs(Node node, Map<Node, Node> oldToNew){
        // base case
        if(node == null){
            return null;
        }
        // 如果已经有node了，说明我们已经处理过它，不用继续往下，直接将前一个node和它的关联起来就可以
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