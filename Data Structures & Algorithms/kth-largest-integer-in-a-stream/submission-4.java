class KthLargest {
    // 如果是brute force
    // 每次都sort一个，取 第n - k个num
    // TC; O(m * nlogn), SC: O(m), m 是新增的num， n is the current size of the arr
    // use a minHeap of size k, keep largest k elements in the heap
    // if the heap size exceeds k, remove the smallest one
    // then the heap top is always the kth largest element
    private PriorityQueue<Integer> minHeap;
    private int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        minHeap = new PriorityQueue<>();
        // 先加，如果超过k再弹，这样保证里面一定有k个元素
        for(int num : nums){
            minHeap.offer(num);
            if(minHeap.size() > k){
                minHeap.poll();
            }
        }
    }
    
    public int add(int val) {
        minHeap.offer(val);
        if(minHeap.size() > k){
            minHeap.poll();
        }
        return minHeap.peek();
    }
}
