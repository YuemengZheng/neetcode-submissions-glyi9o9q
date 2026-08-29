class Solution {
    public boolean hasDuplicate(int[] nums) {
        // loop through the arr and store all the elements in the set
        // when a element is already in the set return true otherwise return false
        // tc:o(n), sc:o(n)
        Set<Integer> set = new HashSet<>();
        for(int num : nums) {
            if(set.contains(num)) return true;
            set.add(num);
        }
        return false;
    }
}