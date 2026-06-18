class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] buckets = new List[nums.length + 1];// 
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            int freq = entry.getValue();
            int num = entry.getKey();
            if(buckets[freq] == null){
                buckets[freq] = new ArrayList<>();
            }
            buckets[freq].add(num);
        }
        int[] res = new int[k];
        int index = 0;
        for(int i = buckets.length - 1; i >= 0 && index < k; i--){
            if(buckets[i] != null){
                for(int num : buckets[i]){
                    res[index++] = num;
                    if(index == k) return res;
                }
            }
        }
        return res;
    }
}
