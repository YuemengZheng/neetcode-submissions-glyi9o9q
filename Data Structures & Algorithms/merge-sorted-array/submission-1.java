class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        /*
        I'll use two pointers starting from the end of both arrays. 
        Since nums1 has empty space at the end, I compare elements from right to left 
        and fill nums1 from the end backward. This avoids overwriting unprocessed elements.
        */
        int i = m - 1;
        int j = n - 1;
        int cur = m + n - 1;
        while(i >= 0 && j >= 0){
            if(nums1[i] >= nums2[j]){
                nums1[cur--] = nums1[i--];
            }else{
                nums1[cur--] = nums2[j--];
            }
        }
        // if nums1 runs out first, need to copy the remaining elements in the nums2 into the nums1
        while(j >= 0){
            nums1[cur--] = nums2[j--];
        }
    }
}