class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // use hashmap to get each num's frequency
        // use k sized min heap to get the top k frequent element
        // tc: nlogk, sc: n
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            pq.offer(new int[]{entry.getKey(), entry.getValue()});
            if(pq.size() > k){
                pq.poll();
            }
        }
        int[] res = new int[k];
        for(int i = 0; i < k; i++){
            res[i] = pq.poll()[0];
        }
        return res;
    }
}
