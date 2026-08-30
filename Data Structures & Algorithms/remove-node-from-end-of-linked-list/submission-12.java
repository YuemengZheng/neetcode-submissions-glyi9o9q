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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 用dummy node 防止边界处理
        // 用快慢指针找到倒数第n + 1个node， 然后将该node的指针指向下下个指针去移除倒数第n个node
        // 先用fast指针move n步
        // 然后slow和fast一起move
        // 当fast到达最后一个node的时候，slow会到达倒数n + 1个node
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;

        while(n > 0){
            fast = fast.next;
            n--;
        }

        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;//不会报错，因为slow.next是要被删除的node，顶多是做后一个node，后面还有一个null
        return dummy.next;
    }
}
