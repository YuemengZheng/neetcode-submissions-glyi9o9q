class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        /*
        First, count the frequency of each number using a HashMap. 
        Then, maintain a min-heap of size k. For each entry, 
        add it to the heap — if the heap exceeds size k, remove the smallest. 
        What remains are the top k frequent elements. Time O(n log k), space O(n)
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
