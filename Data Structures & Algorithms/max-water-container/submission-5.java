class Solution {
    public int maxArea(int[] heights) {
        // use two pointer from both ends
        // so we get the max width
        // for the hight, we always wanna find a higher height, so we always move the pointer with lower height
        int res = 0;
        int l = 0;
        int r = heights.length - 1;
        while(l < r) {
            int area = (r - l) * Math.min(heights[l], heights[r]);
            res = Math.max(area, res);
            if(heights[l] <= heights[r]) {
                l++;
            }else {
                r--;
            }
        }
        return res;
    }
}
