/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        return dfs(head, map);
    }
    private Node dfs(Node node, Map<Node, Node> map){
        if(node == null) return null;
        if(map.containsKey(node)) return map.get(node);

        Node clone = new Node(node.val);
        map.put(node, clone);
        clone.next = dfs(node.next, map);
        clone.random = dfs(node.random, map);

        return clone;
    }
}

