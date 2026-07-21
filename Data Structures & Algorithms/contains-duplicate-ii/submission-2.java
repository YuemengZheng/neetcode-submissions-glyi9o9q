class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // use a hashmap store the element we have meet
        // iterate through the arr, for each element, try to find if there is a valid element has been met
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i]) && i - map.get(nums[i]) <= k) {
                return true;
            }
            map.put(nums[i], i);
        }
        return false;
    }
}