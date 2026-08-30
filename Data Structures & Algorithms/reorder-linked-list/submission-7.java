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
    public void reorderList(ListNode head) {
        // find the middle element
        // reverse the right half
        // merge two list
        if(head.next == null || head.next.next == null) return;

        ListNode mid = getMid(head);
        ListNode rightHalf = mid.next;
        mid.next = null;
        ListNode head1 = reverse(rightHalf);
        merge(head, head1);
    }
    // getMid
    private ListNode getMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    // reverse
    private ListNode reverse(ListNode head) {
        ListNode cur = head;
        ListNode prev = null;
        ListNode next;
        while(cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
    // merge
    private void merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while(l1 != null && l2 != null) {
            cur.next = l1;
            l1 = l1.next;
            cur = cur.next;

            cur.next = l2;
            l2 = l2.next;
            cur = cur.next;
        }
        if(l1 != null) {
            cur.next = l1;
        }
    }
}
