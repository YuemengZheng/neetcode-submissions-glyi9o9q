class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // minHeap
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        // use a arr to store the freq of each element
        // cause we at most have nums.length freq, so the arr length will be nums.length + 1
        // index -> freq
        // each bucket stores list of elements that share the same freq
        // return the k elements from right to left
        List<Integer>[] buckets = new List[nums.length + 1];
        for(int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<>();
        }
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int num = entry.getKey();
            int freq = entry.getValue();
            buckets[freq].add(num);
        }
        int[] res = new int[k];
        for(int i = buckets.length - 1; i > 0; i--) {
            for(int num : buckets[i]) {
                res[--k] = num;
                if(k == 0) return res;
            }
        }
        return res;
    }
}
