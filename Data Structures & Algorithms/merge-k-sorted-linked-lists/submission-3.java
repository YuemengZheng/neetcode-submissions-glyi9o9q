/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        // use k sized priority queue to always get the smallest element
        // every time pop the peek element, push the next element
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));
        for(int i = 0; i < lists.length; i++) {
            if(lists[i] != null) {
                pq.offer(lists[i]);
            }
        }
        while(!pq.isEmpty()) {
            ListNode node = pq.poll();
            cur.next = node;
            cur = cur.next;
            if(node.next != null) pq.offer(node.next);
        }
        return dummy.next;
    }
}
