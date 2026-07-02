class Solution {
    public int splitArray(int[] nums, int k) {
        int max = 0;
        int sum = 0;
        for(int num : nums){
            max = Math.max(max, num);
            sum += num;
        }

        int l = max;
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
    private boolean isValid(int[] nums, int k, int target){
        // greedy 
        // check the smallest cnts of the subarray that each sum of the subarray is at most target
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