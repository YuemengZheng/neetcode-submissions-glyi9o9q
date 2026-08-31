class MedianFinder {
    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;
    public MedianFinder() {
        maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a, b));
    }
    
    public void addNum(int num) {
        int maxHeapSize = maxHeap.size();
        int minHeapSize = minHeap.size();

        if(maxHeapSize == 0) maxHeap.offer(num);
        else if(maxHeapSize > minHeapSize){
            if(maxHeap.peek() > num) {
                minHeap.offer(maxHeap.poll());
                maxHeap.offer(num);
            }else {
                minHeap.offer(num);
            }
        }else {
            if(minHeap.peek() < num) {
                maxHeap.offer(minHeap.poll());
                minHeap.offer(num);
            }else {
                maxHeap.offer(num);
            }
        }
    }
    
    public double findMedian() {
        if(maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();
        }
        return (double)(maxHeap.peek() + minHeap.peek()) / 2;
    }
}
