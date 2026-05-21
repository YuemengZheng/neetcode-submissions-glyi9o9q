class Solution {
    public boolean hasDuplicate(int[] nums) {
        // use a set to store all the elements have been met
        // iterate through the array, if we find a element has been met in the set, return true
        // otherwise return false
        Set<Integer> hasMet = new HashSet<>();
        for(int num : nums){
            if(hasMet.contains(num)){
                return true;
            }
            hasMet.add(num);
        }
        return false;
    }
}