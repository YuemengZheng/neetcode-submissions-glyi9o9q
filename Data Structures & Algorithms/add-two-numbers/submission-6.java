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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // visit two lists, sum up two nums together
        // final get the sum list
        
        if(l1 == null) return l2;
        if(l2 == null) return l1;

        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        int carry = 0;
        int curSum = 0;

        while(l1 != null || l2 != null || carry != 0){
            curSum = carry;
            if(l1 != null){
                curSum += l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                curSum += l2.val;
                l2 = l2.next;
            }
            carry = curSum / 10;
            curSum %= 10;
            cur.next = new ListNode(curSum);
            cur = cur.next;
        }
        return dummy.next;
    }
}
