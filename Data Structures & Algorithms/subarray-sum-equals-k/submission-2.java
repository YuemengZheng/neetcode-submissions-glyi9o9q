class Solution {
    public int subarraySum(int[] nums, int k) {
        // XXXXX sliding window
        // int cnt = 0;
        // int sum = 0;
        // int l = 0;
        // int r = 0;
        // while(r < nums.length){
        //     sum += nums[r++];
        //     while(sum == k){
        //         cnt++;
        //         sum -= nums[l++];
        //     }
        // }
        // return cnt;

        // 利用prefixsum 和 hashmap， 对于每一个end，check 是否存在start，他们的subarry sum == k
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // initialize!!!!
        int sum = 0;
        int res = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            int complement = sum - k;
            if(map.containsKey(complement)){
                res += map.get(complement);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return res;
    }
}