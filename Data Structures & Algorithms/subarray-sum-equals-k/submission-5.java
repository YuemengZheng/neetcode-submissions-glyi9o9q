class Solution {
    public int subarraySum(int[] nums, int k) {
        // 因为存在负数，要求求和，不能用sliding window
        // 利用prefixsum 和 hashmap， 对于每一个end，check 是否存在start，他们的subarry sum == k

        /*
        Can I clarify the constraints — what's the range of the elements, and can they be negative?

        I'll use prefix sums with a HashMap
        The key idea is that a subarray's sum equals the difference between two prefix sums. 
        So for each position as the end of a subarray, I count how many earlier prefix sums would make the subarray sum to k.

        I keep a running sum and a HashMap. 
        I initialize the map with prefix sum 0 mapped to 1, to handle subarrays starting from index 0."     
        Then I go through the arr. for each element，First I update the running sum. 
        Then I look up sum - k in the map and add its count to my answer. 
        Finally I store the current sum into the map.

        */
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
/*
Let me trace through [2, -1, 1, 2] with k = 2.
I start with the map holding prefix sum 0 with count 1, and running sum 0.
First number is 2 — sum becomes 2. I look up sum - k, which is 0. It's in the map once, so count becomes 1. 
Then I store sum 2 in the map.
Next is -1 — sum becomes 1. I look up 1 - 2 = -1. It's not in the map, so count stays 1. I store sum 1.
Next is 1 — sum becomes 2. I look up 2 - 2 = 0, which is in the map once, so count becomes 2. I store sum 2, now it's seen twice.
Last is 2 — sum becomes 4. I look up 4 - 2 = 2, which is in the map twice, so count becomes 4.
The final answer is 4.

No, that wouldn't work. 
The key is we need to count earlier prefix sums only. 
If I store the current sum first, the answer would be wrong. 
*/