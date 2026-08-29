class Solution {
    public int[] twoSum(int[] nums, int target) {
        // use a hashmap to store all the elements we have seen right now
        // loop through the nums arr, when the map contains cur implement, return two indecie
        // otherwise store the element in the map
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            int implement = target - nums[i];
            if(map.containsKey(implement)) {
                return new int[]{map.get(implement), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{0, 0};
    }
}
