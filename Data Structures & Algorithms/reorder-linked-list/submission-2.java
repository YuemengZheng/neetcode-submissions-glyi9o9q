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
        // ***** TIME: O(n), SPACE:O(1) *****
        // 找到中点，反转右边部分，合并左右部分
        if(head == null || head.next == null || head.next.next == null){
            return;
        }
        ListNode mid = findMid(head);
        ListNode second = mid.next;
        mid.next = null;// ??
        ListNode head2 = reverse(second);
        combine(head, head2);
    }
    // 快慢指针找到中点
    public ListNode findMid(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode reverse(ListNode head){
        ListNode cur = head;
        ListNode prev = null;
        ListNode next;
        while(cur != null){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    public void combine(ListNode one, ListNode two) {
        while (two != null) {
            ListNode next1 = one.next;
            ListNode next2 = two.next;

            one.next = two;
            two.next = next1;

            one = next1;
            two = next2;
        }
    }

}
