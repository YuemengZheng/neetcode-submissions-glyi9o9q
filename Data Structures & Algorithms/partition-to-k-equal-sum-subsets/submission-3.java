class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        // use backtracking
        // each level represents one element， try to place it in one section
        // finally, if there is a path that each sum of the section is the same return true
        // otherwise return false

        // input: nums, k sized sum arr, cur, target sum of subset, return boolean
        // base case: if cur hits the end of the arr, check if all the sebsets share the same sum, return true, return false
        // try to put the element into each section, and recurse on the next index and backtrack 

        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        if(sum % k != 0) return false;
        // By sorting in descending order, larger elements are placed first. 
        // Since larger elements have fewer valid positions, we can prune invalid paths earlier and reduce the search space
        Arrays.sort(nums);
        for(int i = 0, j = nums.length - 1; i < j; i++, j--){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        return backtracking(nums, k, 0, new int[k], sum / k);
    }
    private boolean backtracking(int[] nums, int k, int cur, int[] sums, int targetSum){
        if(cur == nums.length){
            for(int sum : sums){
                if(sum != targetSum) return false;
            }
            return true;
        }

        for(int i = 0; i < k; i++){
            if(sums[i] + nums[cur] > targetSum) continue;
            sums[i] += nums[cur];
            if(backtracking(nums, k, cur + 1, sums, targetSum)) return true;
            sums[i] -= nums[cur];
        }
        return false;
    }
}