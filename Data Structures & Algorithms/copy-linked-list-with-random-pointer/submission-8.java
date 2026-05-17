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
        // iteration
        // 使用map记录原来的node和cloned node之间的mapping关系
        // 沿着next pointer iterate through the nodes
        // 先从map里面拿出cur node
        // 建立next node and random node
        if(head == null) return null;
        Map<Node, Node> map = new HashMap<>();
        Node clonedNode = new Node(head.val);
        Node orignalNode = head;
        map.put(orignalNode, clonedNode);
        while(orignalNode != null){
            clonedNode = map.get(orignalNode);
            if(orignalNode.next != null && !map.containsKey(orignalNode.next)){
                map.put(orignalNode.next, new Node(orignalNode.next.val));
            }
            clonedNode.next = map.get(orignalNode.next);
            if(orignalNode.random != null && !map.containsKey(orignalNode.random)){
                map.put(orignalNode.random, new Node(orignalNode.random.val));
            }
            clonedNode.random = map.get(orignalNode.random);
            orignalNode = orignalNode.next;
        }
        return map.get(head);
        
    }
}
