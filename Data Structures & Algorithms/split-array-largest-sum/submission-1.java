class Solution {
    public int splitArray(int[] nums, int k) {
        // High level: binary search on the answer
        // The answer (minimized largest subarray sum) must be in range [max(nums), sum(nums)]
        // - min: at least able to fit the largest single element
        // - max: the entire array as one subarray
        // For each mid, we greedily check if it's achievable with <= k subarrays
        // We want the smallest valid mid, so when valid we go left (r = mid - 1), return l
        
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