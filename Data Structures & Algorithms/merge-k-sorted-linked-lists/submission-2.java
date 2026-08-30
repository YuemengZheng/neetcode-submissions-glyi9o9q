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
        // minheap
        // Time: O(N log k), Space: O(k)
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        for(int i = 0; i < lists.length; i++){
            if(lists[i] != null) minHeap.offer(lists[i]);
        }
        while(!minHeap.isEmpty()) {
            ListNode min = minHeap.poll();
            cur.next = min;
            cur = cur.next;
            if(min.next != null) minHeap.offer(min.next);
        }
        return dummy.next;
    }
}
