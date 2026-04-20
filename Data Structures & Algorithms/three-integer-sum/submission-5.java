class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        /*
        Our goal is to find all the triplets that sum up to zero. First, 
        I'll sort the array in ascending order. 
        Then for each element, I'll use two pointers one the remaining array 
        — one pointer at the start and one at the end.
        I'll get the sum of three elements. 
        If it equals zero, I'll collect the triplet. 
        Otherwise, if it's too small, I'll move the left pointer right. 
        if it's too large, I'll move the right pointer left. 
        Since we need to avoid duplicate triplets, 
        I'll skip over duplicates for all three pointers
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
