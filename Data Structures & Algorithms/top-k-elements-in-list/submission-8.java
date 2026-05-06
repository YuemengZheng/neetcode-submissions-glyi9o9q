class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        /*
        I first use a hashmap to count the frequency of each element.
        Then I use bucket sort, where the index represents the frequency,
        and each bucket stores the elements with that frequency.

        Finally, I iterate from right to left,
        and collect k elements
        */

        Map<Integer, Integer> freq = new HashMap<>();
        for(int num : nums){
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        List<Integer>[] buckets = new List[nums.length + 1];
        for(Map.Entry<Integer, Integer> entry : freq.entrySet()){
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
                    if(index == k)break;
                }
            }
        }
        return res;
    }
}

// time: O(n)
// space: O(n)

// if use min heap => nlogk | n + k
