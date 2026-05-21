class Solution {
    public int[] twoSum(int[] nums, int target) {
        /*
        use a map to store the elements we have seen so far
        iterate through the array
        when we find the target - cur in the map
        return the pair of indices
        otherwise, add the element to the map
        */
        Map<Integer, Integer> seen = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int find = target - nums[i];
            if(seen.containsKey(find)){
                return new int[]{seen.get(find), i};
            }
            seen.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }
}
