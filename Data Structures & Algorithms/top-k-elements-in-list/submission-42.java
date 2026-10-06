class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // get the freq of each element
        // use an arr that index -> the freq, each bucket store all the elements that share the same freq
        // finally return the k element from right to left
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int n = nums.length;
        List<Integer>[] buckets = new List[n + 1];
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int num = entry.getKey();
            int freq = entry.getValue();
            if(buckets[freq] == null) buckets[freq] = new ArrayList<>();
            buckets[freq].add(num);
        }
        int[] res = new int[k];
        int index = 0;
        for(int i = n; i >= 0 && index < k; i--) {
            if(buckets[i] != null) {
                for(int num : buckets[i]) {
                    res[index++] = num;
                    if(index == k) break;
                }
            }
        }
        return res;
    }
}
