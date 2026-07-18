class Solution {
    public int subarraySum(int[] nums, int k) {
        // prefix sum 
        // use hashmap to store all the prefix sum meet 
        // loop through each prefix sum, check if there exists prefix sums that the diff == k
        // update the cnt, put the prefix sum into the map
        int[] prefix = new int[nums.length];
        prefix[0] = nums[0];
        for(int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }

        Map<Integer, Integer> prefixToCnt = new HashMap<>();
        prefixToCnt.put(0, 1);
        int cnt = 0;
        for(int i = 0; i < nums.length; i++) {
            if(prefixToCnt.containsKey(prefix[i] - k)) {
                cnt += prefixToCnt.get(prefix[i] - k);
            }
            prefixToCnt.put(prefix[i], prefixToCnt.getOrDefault(prefix[i], 0) + 1);
        }
        return cnt;
    }
}