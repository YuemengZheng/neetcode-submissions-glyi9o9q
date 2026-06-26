class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        // I'll fix two elements, then use two pointers to find the remaining two elements that sum to the target
        // int 的范围: 约 ±2.1 × 10⁹ 超过这个范围就要long
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < nums.length - 3; i++){
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            for(int j = i + 1; j < nums.length - 2; j++){
                if(j > i + 1 && nums[j] == nums[j - 1]) continue;
                int l = j + 1;
                int r = nums.length - 1;
                while(l < r){
                    // I'll use long for the sum to avoid potential integer overflow
                    long sum = (long)nums[i] + nums[j] + nums[l] + nums[r];
                    if(sum == target){
                        res.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                        l++;
                        r--;
                        while(l < r && nums[l] == nums[l - 1]){
                            l++;
                        }
                        while(l < r && nums[r] == nums[r + 1]){
                            r--;
                        }
                    }else if(sum < target){
                        l++;
                    }else{
                        r--;
                    }
                }
            }
        }
        return res;
    }
}