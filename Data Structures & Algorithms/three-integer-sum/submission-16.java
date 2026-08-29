class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // fix one element and use two pointers from both ends to find the three elements that sum up to 0
        // skip all the duplicates
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < nums.length - 2; i++) {
            if(i > 0 && nums[i - 1] == nums[i]) continue;
            int l = i + 1;
            int r = nums.length - 1;
            while(l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if(sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    l++;
                    r--;
                    while(l < r && nums[l] == nums[l - 1]) l++;
                    while(l < r && nums[r] == nums[r + 1]) r--;
                }else if(sum < 0) {
                    l++;
                }else{
                    r--;
                }
            }
        }
        return res;
    }
}
