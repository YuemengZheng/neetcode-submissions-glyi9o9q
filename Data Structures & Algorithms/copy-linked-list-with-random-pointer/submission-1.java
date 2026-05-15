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
        // iterate 顺着next指针
        // 1.1 如果node存在在map，直接拿来用
        // 1.2 如果不存在，copy node
        // 2 建立联系
        if(head == null) return null;

        Map<Node, Node> map = new HashMap<>();
        Node copy = new Node(head.val);
        Node cur = head;
        map.put(head, copy);
        while(cur != null){
            copy = map.get(cur);
            if(cur.next != null && !map.containsKey(cur.next)){
                map.put(cur.next, new Node(cur.next.val));
            }
            copy.next = map.get(cur.next);
            if(cur.random != null && !map.containsKey(cur.random)){
                map.put(cur.random, new Node(cur.random.val));
            }
            copy.random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }
}
