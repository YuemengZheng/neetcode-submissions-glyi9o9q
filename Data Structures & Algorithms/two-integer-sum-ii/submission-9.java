class Solution {
    public int[] twoSum(int[] numbers, int target) {
        /*
        Since the array is sorted, I use two pointers 
        starting from both ends of the array.
        first, I get the sum of them. 
        If it equals the target, I return the indices. 
        If it's too small, I move the left pointer right. 
        If it's too large, I move the right pointer left
        */
        // ***** TIME: O(n), SPACE:O(1) *****
        int l = 0, r = numbers.length - 1;
        while(l < r){
            int sum = numbers[l] + numbers[r];
            if(sum == target){
                return new int[]{l+1, r+1};
            }
            if(sum < target){
                l++;
            }else{
                r--;
            }
        }
        return new int[]{-1, -1};
    }
}

