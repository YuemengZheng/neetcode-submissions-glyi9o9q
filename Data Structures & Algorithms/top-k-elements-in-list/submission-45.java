class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // top k
        // get the frequency of each num
        // use an arr to store all the elements
        // index -> frequency
        // each bucket stores all the elements that share the same frequency
        // get the k elements from right to left
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // the most frequency of one element is n, so we create an arr with n + 1 length
        List<Integer>[] arr = new List[nums.length + 1];
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int num = entry.getKey();
            int freq = entry.getValue();
            if(arr[freq] == null) arr[freq] = new ArrayList<>();
            arr[freq].add(num);
        }

        int[] res = new int[k];
        int i = 0;
        for(int j = arr.length - 1; j >= 0 && i < k; j--) {
            if(arr[j] != null && i < k) {
                for(int num : arr[j]) {
                    res[i++] = num;
                    if(i == k) break;
                }
            }
        }
        return res;
    }
}
