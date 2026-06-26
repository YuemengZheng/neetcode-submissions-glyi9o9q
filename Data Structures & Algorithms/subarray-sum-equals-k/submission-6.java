class Solution {
    public int subarraySum(int[] nums, int k) {
        // initialize a hashmap and a running sum = 0, cnt = 0
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0;
        int cnt = 0;
        // loop through the arr, for each element
        for(int i = 0; i < nums.length; i++){
        // 1. update the sum
            sum += nums[i];
        // 2. look up the sum - k in the map, add the count to the cnt
            if(map.containsKey(sum - k)){
                cnt += map.get(sum - k);
            }
        // 3. add the sum to the map
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        // return cnt
        return cnt;
    }
}