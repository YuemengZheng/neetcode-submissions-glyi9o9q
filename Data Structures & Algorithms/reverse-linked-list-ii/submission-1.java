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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // build a dummy node
        // find the preLeft node, used for connection
        // start from the next of the preLeft as the cur node,
        // reverse the nodes from left position to right position
        // connect them back to the original list
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode preLeft = dummy;
        for(int i = 1; i < left; i++){
            preLeft = preLeft.next;
        }
        ListNode cur = preLeft.next;
        ListNode prev = null;
        ListNode nxt = cur.next;
        for(int j = left; j <= right; j++){
            nxt = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nxt;
        }
        preLeft.next.next = nxt;
        preLeft.next = prev;
        return dummy.next;
    }
}