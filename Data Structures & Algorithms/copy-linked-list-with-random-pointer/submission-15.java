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
        Node cur = head;
        while(cur != null){
            Node clonedNode = getOrCreate(cur, map);
            clonedNode.next = getOrCreate(cur.next, map);
            clonedNode.random = getOrCreate(cur.random, map);
            cur = cur.next;
        }
        return map.get(head);
    }
    private Node getOrCreate(Node node, Map<Node, Node> map){
        if(node == null) return null;
        if(map.containsKey(node)) return map.get(node);

        Node clonedNode = new Node(node.val);
        map.put(node, clonedNode);
        return clonedNode;
    }
}
