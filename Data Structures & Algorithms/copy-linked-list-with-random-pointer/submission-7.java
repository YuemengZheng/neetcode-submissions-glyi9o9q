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
        if (head == null) return null;
        map = new HashMap<>();
        map.put(head, new Node(head.val));
        Node cur = head;
        while (cur != null) {
            Node copy = map.get(cur);
            copy.next = process(cur.next);
            copy.random = process(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }
    private Node process(Node node) {
        if (node == null) return null;
        if (!map.containsKey(node)) {
            Node newNode = new Node(node.val);
            map.put(node, newNode);
        }
        return map.get(node);
    }
    
}
