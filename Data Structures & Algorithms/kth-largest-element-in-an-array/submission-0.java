class Solution {
    public int findKthLargest(int[] nums, int k) {
        // use minHeap of size k
        // *********TC: O(nlogk), SC: O(k)*********
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int num : nums){
            minHeap.offer(num);
            if(minHeap.size() > k){
                minHeap.poll(); 
            }
        }
        return minHeap.peek();
    }
}
