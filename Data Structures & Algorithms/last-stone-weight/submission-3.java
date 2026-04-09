class Solution {
    public int lastStoneWeight(int[] stones) {
        // * At each step we choose the two heaviest stones
        // brute force, sort the array
        // 因为我们会有残值需要加入list，所以每一轮都要重新sort
        // n^2logn
        // We always need to repeatedly remove the two heaviest stones.
        // A max-heap is perfect for this because it lets us efficiently extract the largest values.
        // create a max heap using a custom comparator
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for(int stone : stones){
            maxHeap.offer(stone);
        }

        while(maxHeap.size() > 1){
            int x = maxHeap.poll();
            int y = maxHeap.poll();
            if(x != y){
                maxHeap.offer(x - y);
            }
        }
        return maxHeap.isEmpty() ? 0 : maxHeap.poll();
    }
}
