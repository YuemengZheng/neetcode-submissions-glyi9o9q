class Solution {
    public int maxArea(int[] heights) {
        // use two pointers starting from both ends of the arr
        // we get the max width, for the hight, when we narrow the width, we try to find a higher height
        // move the pointer with shorter height
        int max = 0;
        int l = 0;
        int r = heights.length - 1;
        while(l < r) {
            int height = Math.min(heights[l], heights[r]);
            max = Math.max(max, height * (r - l));

            if(heights[l] < heights[r]) {
                l++;
            } else {
                r--;
            }
        }
        return max;
    }
}
