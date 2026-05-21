class Solution {
    public boolean hasDuplicate(int[] nums) {
        /*
        The idea is to use a HashSet to track numbers we've already seen. 
        We iterate through the array once — for each number, 
        we check if it's already in the set. 
        If yes, we found a duplicate and return true. 
        If not, we add it to the set. 
        If we finish the loop without finding any duplicate, we return false. 
        This gives us O(n) time and O(n) space.
        */
        Set<Integer> seen = new HashSet<>();
        for(int num : nums){
            if(seen.contains(num)){
                return true;
            }
            seen.add(num);
        }
        return false;
    }
}