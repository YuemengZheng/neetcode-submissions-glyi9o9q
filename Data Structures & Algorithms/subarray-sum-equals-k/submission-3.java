class Solution {
    public int subarraySum(int[] nums, int k) {
        // 因为存在负数，要求求和，不能用sliding window
        // 利用prefixsum 和 hashmap， 对于每一个end，check 是否存在start，他们的subarry sum == k
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0;
        int cnt = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int complement = sum - k;
            if(map.containsKey(complement)) {
                cnt += map.get(complement);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return cnt;
    }
}