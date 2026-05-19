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
        // visit two lists, do the sum, record the final result in the new list
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        int curNum = 0;
        int count = 0;
        while(p1 != null || p2 != null || count != 0){
            curNum = count;
            if(p1 != null){
                curNum += p1.val;
                p1 = p1.next;
            }
            if(p2 != null){
                curNum += p2.val;
                p2 = p2.next;
            }
            count = curNum / 10;
            curNum = curNum % 10;
            cur.next = new ListNode(curNum);
            cur = cur.next;
        }
        return dummy.next;
    }
    
}
