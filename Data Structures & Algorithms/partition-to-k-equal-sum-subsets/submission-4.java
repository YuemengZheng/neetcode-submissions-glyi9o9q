class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        /*
        High level: use backtracking where each element tries to place itself into one of the k subsets.
        Sort in descending order for better pruning.

        Main steps:
        - Helper function inputs: nums, k sized sums array, current index, target sum
        - Base case: if current index equals array length, return true
        - For each subset, skip if adding current element exceeds target,
          or if current subset sum equals previous subset sum (avoid duplicates)
        - Add element, recurse to next index, backtrack

        TC: O(k^n) with pruning, SC: O(n) for recursion stack
        */

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