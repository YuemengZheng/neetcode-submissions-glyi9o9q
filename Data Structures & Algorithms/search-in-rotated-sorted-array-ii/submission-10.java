class Solution {
    public boolean search(int[] nums, int target) {
        /*
        Goal
        "So the problem here is: given a rotated sorted array that might have duplicates, 
        I need to figure out whether a target value exists in it."

        High Level
        "The key idea is, this is just a variation of binary search. 
        In a rotated sorted array, no matter where you split it, 
        one of the two halves is always going to be sorted. So at each step, 
        I figure out which half is sorted, and then check if the target falls inside that 
        sorted range. If it does, I search there — otherwise I search the other side. 
        The tricky part with duplicates is, sometimes I can't tell which half is sorted, 
        so I need to handle that separately."

        Main Steps
        "I start with a left and right pointer at the two ends. 
        Then, for each middle element, first I check if it's the target — 
        if so, I'm done, return true.

        If it's not, I look at whether left, mid, and right are all equal. 
        If they are, I really can't tell which side is sorted,
        so I just move both pointers in by one — left up, right down — 
        and move on to the next iteration.
        
        Otherwise, I check if the left half is sorted, by comparing the left and mid values. 
        If the left side is sorted, I check whether the target falls in that range 
        — if it does, I move into the left half; if not, I go right.

        If instead the right half is the sorted one, same idea — 
        I check if the target's in that range, and narrow down accordingly.

        And if I get through the whole loop without finding it, 
        that just means the target's not there, so I return false."

        Example
        "Let's say nums is [1, 0, 1, 1, 1], and target is 0. 
        Left and right start at the two ends, mid lands in the middle, 
        and all three values happen to be 1 — so I can't tell which side's sorted, 
        and I just shrink both ends in by one. Now the range is smaller, 
        and this time the left value is 0, which is less than mid, so the left half is sorted. 
        I check — is 0 in that range? Yes. So I move into the left half, 
        and eventually mid lands right on the 0, and I return true."

        Complexity
        "Time complexity is usually O(log n), since we're halving the search space most of the time.
        But in the worst case — like if the whole array is just duplicates — 
        we end up only shrinking one element at a time, so it degrades to O(n). 
        Space is O(1), since I'm just using pointers."
        */
    
        int l = 0;
        int r = nums.length - 1;
        while(l <= r) {
            int mid = l + (r - l) / 2;
            if(nums[mid] == target) {
                return true;
            }
            if(nums[l] == nums[mid] && nums[mid] == nums[r]) {
                l++;
                r--;
            }
            else if(nums[mid] <= nums[r]) {
                if(target > nums[mid] && target <= nums[r]) {
                    l = mid + 1;
                }else{
                    r = mid - 1;
                }
            // 因为会遇到重复元素，我们一旦遇到重复元素，就不知道应该往哪里挪动，所以r--
            }else{
                if(target >= nums[l] && target < nums[mid]) {
                    r = mid - 1;
                }else {
                    l = mid + 1;
                }
            }
        }
        return false;
    }
}