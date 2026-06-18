class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for(int num : nums){
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        for(Map.Entry<Integer, Integer> entry : freq.entrySet()){
            minHeap.offer(new int[]{entry.getKey(), entry.getValue()});
            if(minHeap.size() > k){
                minHeap.poll();
            }
        }
        int[] res = new int[k];
        int i = 0;
        while(i < k){
            res[i++] = minHeap.poll()[0];
        }
        return res;
    }
}
