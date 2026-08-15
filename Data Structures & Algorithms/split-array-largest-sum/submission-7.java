class Solution {
    public int splitArray(int[] nums, int k) {
        /*
        So for this problem, because there's a very clear range — the answer falls between the max of the array and the sum of the array, 
        since we can either store one element per subarray or the entire array in one subarray. 
        Within this range, there's a monotonic property: if a value is valid, anything larger is also valid. 
        This makes it perfect for binary search. 
        For each mid, I greedily check if we can split the array into at most k subarrays where each sum doesn't exceed mid. 
        If it's valid, I search left for a smaller answer. If it's invalid, I search right for a larger answer.

        */
        /*
        O(n log m) where n is the number of elements and m is the sum of all elements.

        log m — binary search range is from max(nums) to sum(nums), so at most log m iterations
        n — each iteration calls isValid which traverses the entire array once

        Space complexity is O(1) since we only use a constant amount of extra space.
        */
        
        int maxNum = 0;
        int sum = 0;
        for(int num : nums){
            maxNum = Math.max(num, maxNum);
            sum += num;
        }
        int l = maxNum;
        int r = sum;
        while(l <= r){
            int mid = l + (r - l) / 2;
            if(isValid(nums, k, mid)){
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        return l;
    }
        
    // Greedy check: given a max allowed subarray sum (target),
    // count the minimum number of subarrays needed
    // If cnt <= k, this target is achievable (we can always split further to reach exactly k)
    // Splitting further may or may not reduce the answer, but binary search will explore those smaller values anyway
    private boolean isValid(int[] nums, int k, int target){
        int cnt = 0;
        int i = 0;
        while(i < nums.length){
            int sum = 0;
            while(i < nums.length && sum + nums[i] <= target){
                sum += nums[i];
                i++;
            }
            cnt++;
        }
        return cnt <= k;
    }
}