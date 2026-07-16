class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // top k most frequent element
        // compute the frequency of each element
        // use a minheap to always get k sized most frequent element
        Map<Integer, Integer> numToFreq = new HashMap<>();
        for(int num : nums) {
            numToFreq.put(num, numToFreq.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        for(Map.Entry<Integer, Integer> entry : numToFreq.entrySet()) {
            minHeap.offer(new int[]{entry.getKey(), entry.getValue()});
            if(minHeap.size() > k) {
                minHeap.poll();
            }
        }

        int[] res = new int[k];
        int i = 0;
        while(i < k) {
            res[i++] = minHeap.poll()[0];
        }
        return res;
    }
}
