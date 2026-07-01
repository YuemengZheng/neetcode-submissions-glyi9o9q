class Solution {
    public int splitArray(int[] nums, int k) {
        // 这个和运货船只很像
        // 我们首先有一个范围，sum of subarray 的范围， max 到 sum of arr
        // 然后用binary search去找到最小的sum of subarray，用helper function check 是不是可以
        // 这里有一点贪心的想法，就是看最少分几组，每一组最多sum = target， 如果分组 <= k， 可以这样分
        // 因为我们可以宽松点再多分几组恰好到k组，这样可能会影响sum of subarray， 但是没有关系，因为如果会有影响
        // 我们接下来的mid会到那边去，不会遗漏答案，但是如果不影响，我们的答案就是当前，怎么分配也不会影响结果
        
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