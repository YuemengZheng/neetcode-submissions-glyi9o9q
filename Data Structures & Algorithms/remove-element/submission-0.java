class Solution {
    public int removeElement(int[] nums, int val) {
        /*
        move all the elements that are not equal to the val to the front of the array
        return the number of such elements

        use two pointer approach
        i tracks where the next non-val element should go, 
        and j scans through the array looking for elements that are not equal to val. 
        When you find one, you place it at position i and move i forward. 
        finally i is the count of the elements
        */
        int i = 0;
        for(int j = 0; j < nums.length; j++){
            if(nums[j] != val){
                nums[i++] = nums[j];
            }
        }
        return i; 
    }
}