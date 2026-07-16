class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // bucket sort
        // get the frequency of each element
        // use a arr of n, index -> the frequency
        // each bucket store all the element with that frequency
        // finally, collect top k elements from right to left
        Map<Integer, Integer> freq = new HashMap<>();
        for(int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] buckets = new ArrayList[nums.length + 1];
        for(int i = 0; i <= nums.length; i++) {
            buckets[i] = new ArrayList<>();
        }
        for(Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            buckets[entry.getValue()].add(entry.getKey());
        }
        int[] res = new int[k];
        for(int i = nums.length; i >= 0 && k > 0; i--) {
            List<Integer> list = buckets[i];
            for(int num : list) {
                res[--k] = num;
                if(k == 0) return res;
            }
        }
        return res;
    }
}
