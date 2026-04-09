class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // map 统计每个数字出现的次数
        // 桶排序，设置n + 1个桶
        // bucket[i] 存储出现i次的所有数字 进行归类
        // 从后往前数k个
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Integer>[] bucket = new List[nums.length + 1];
        for(int key : map.keySet()){
            int freq = map.get(key);
            if(bucket[freq] == null){
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(key);
        }
        int[] res= new int[k];
        int index = 0;
        for(int i = bucket.length - 1; i >= 0 && index < k; i--){
            if(bucket[i] != null){
                for(int num : bucket[i]){
                    res[index++] = num;
                    if(index == k) break;
                }
            }
        }
        return res;
    }
}
// time: O(n)
// space: O(n)
