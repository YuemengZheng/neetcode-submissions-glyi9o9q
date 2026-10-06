class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // get the freq of each element
        // use minHeap to always keep top k frequent elements
        // tc: nlogk + klogk, sc: k + n
        Map<Integer, Integer> freq = new HashMap<>();
        for(int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        for(Map.Entry<Integer, Integer> pair : freq.entrySet()) {
            minHeap.offer(new int[]{pair.getKey(), pair.getValue()});
            if(minHeap.size() > k) {
                minHeap.poll();
            }
        }
        int[] res = new int[k];
        for(int i = 0; i < k; i++) {
            res[i] = minHeap.poll()[0];
        }
        return res;
    }
}
