class KthLargest {
    // 如果是brute force
    // 每次都sort一个，取 第n - k个num
    // TC; O(m * nlogn), SC: O(m), m 是新增的num， n is the current size of the arr

    // 利用minheap优化： minheap of size k，先装k个，然后拿(n - k)和栈顶比，比栈顶大就替换，重新排序
    // klogk + (n - k)*logk => nlogk, space => k
    private PriorityQueue<Integer> minHeap;
    private int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.minHeap = new PriorityQueue<>();
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
