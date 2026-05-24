class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        /*
        I sort the array first, then fix one number and use two pointers to find the remaining two numbers.

        For each fixed number, I use left and right pointers to search for a sum of zero.
        If the sum is too small, I move left right; if it is too large, I move right left.
        After finding a valid triplet, I skip duplicates before continuing
        */
        // ***** TIME: O(n^2), SPACE:O(1) *****
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < nums.length - 2; i++){
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            int l = i + 1;
            int r = nums.length - 1;
            while(l < r){
                int sum = nums[i] + nums[l] + nums[r];
                if(sum == 0){
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    l++;
                    r--;
                    while(l < r && nums[l] == nums[l - 1]){
                        l++;
                    }
                    while(l < r && nums[r] == nums[r + 1]){
                        r--;
                    }
                }else if(sum < 0){
                    l++;
                }else{
                    r--;
                }
            }
        }
        return res;
    }
}
