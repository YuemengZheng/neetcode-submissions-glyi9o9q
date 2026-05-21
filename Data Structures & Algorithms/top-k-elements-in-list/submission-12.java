class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        /*
        get each number's frequency in the nums
        use k sized 最小堆，最终得到top k frequent elements
        nlogk| n
        */
        Map<Integer, Integer> cnts = new HashMap<>();
        for(int num : nums){
            cnts.put(num, cnts.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));// compare
        for(Map.Entry<Integer, Integer> entry : cnts.entrySet()){
            minHeap.offer(new int[]{entry.getKey(), entry.getValue()});
            if(minHeap.size() > k){
                minHeap.poll();
            }
        }
        int[] res = new int[k];
        for(int i = 0; i < k; i++){
            res[i] = minHeap.poll()[0];
        }
        return res;
    }
}
