class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // use hashmap to get the frequency of each element
        // use bucket sort, the index represents the frequency
        // and the bucket stores the element with that frequency
        // iterate through the bucket from right to left to get the top k frequent elements
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        // 可能会遇到一样frequency的element，所以bucket里面要用list存
        List<Integer>[] buckets = new List[nums.length + 1];
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            int num = entry.getKey();
            int cnt = entry.getValue();
            if(buckets[cnt] == null){
                buckets[cnt] = new ArrayList<>();
            }
            buckets[cnt].add(num);
        }

        int[] res = new int[k];
        int index = 0;
        for(int i = buckets.length - 1; i >= 0 && index < k; i--){
            if(buckets[i] != null){
                for(int num : buckets[i]){
                    res[index++] = num;
                    if(index == k) break;
                }
            }
        }
        return res;
    }
}
