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
    Map<Node, Node> map;
    public Node copyRandomList(Node head) {
        map = new HashMap<>();
        return copy(head);
    }
    private Node copy(Node node) {
        if (node == null) return null;
        if (map.containsKey(node)) {
            return map.get(node);
        }
        Node root = new Node(node.val);
        map.put(node, root);
        root.next = copy(node.next);
        root.random = copy(node.random);
        return root;
    }
    
}
