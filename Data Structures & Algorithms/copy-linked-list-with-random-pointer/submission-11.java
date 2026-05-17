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
    private Node dfs(Node head, Map<Node, Node> map){
        if(head == null) return null;
        if(map.containsKey(head)) return map.get(head);

        Node clonedNode = new Node(head.val);
        map.put(head, clonedNode);
        clonedNode.next = dfs(head.next, map);
        clonedNode.random = dfs(head.random, map);

        return clonedNode;
    }
}

