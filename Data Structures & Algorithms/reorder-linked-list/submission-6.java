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
        // reorder the list， 使得第i个node和n-i个node连在一起，我的想法是可以从两端每次取两个node合并
        // 1. 找到middle node
        // 2. 将后半段反转
        // 3. 各自从两端取一个node组合
        if(head == null || head.next == null || head.next.next == null) return;
        ListNode mid = findMiddle(head);
        ListNode head2 = reverse(mid.next);
        mid.next = null;
        combine(head, head2);
    }
    private ListNode findMiddle(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    private ListNode reverse(ListNode node){
        if(node.next == null){
            return node;
        }

        ListNode newHead = reverse(node.next);
        node.next.next = node;
        node.next = null;

        return newHead;
    }
    private void combine(ListNode list1, ListNode list2){
        while(list2 != null){
            ListNode next1 = list1.next;
            ListNode next2 = list2.next;

            list1.next = list2;
            list2.next = next1;

            list1 = next1;
            list2 = next2;
        }
    }
}
