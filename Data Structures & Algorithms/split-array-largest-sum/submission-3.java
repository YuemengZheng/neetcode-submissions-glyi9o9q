class Solution {
    public int splitArray(int[] nums, int k) {
        // tc : o(nlogm) sc:o(1)
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
/*
nums = [2,4,10,1,5], k = 2
l = 10
r = 22
[10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22]
                     r    l  
l = 10
r = 22
m = 16
cnt = 2 

l = 10
r = 15
m = 12
false

l = 12
r = 15
m = 13
false

l = 14
r = 15
m = 14
false

l = 15
r = 15
m = 15
false

return 16

*/