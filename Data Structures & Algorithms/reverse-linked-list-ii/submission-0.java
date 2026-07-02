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
        // find the start and end of the list
        // reverse the list
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode preLeft = dummy;
        for(int i = 1; i < left; i++){
            preLeft = preLeft.next;
        }
        ListNode leftNode = preLeft.next;
        ListNode rightNode = leftNode;
        for(int i = left; i < right; i++){
            rightNode = rightNode.next;
        }
        ListNode postRight = rightNode.next;
        
        ListNode prev = postRight;
        ListNode cur = leftNode;
        ListNode next;
        while(cur != postRight){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        preLeft.next = rightNode;
        leftNode.next = postRight;
        return dummy.next;
    }
}