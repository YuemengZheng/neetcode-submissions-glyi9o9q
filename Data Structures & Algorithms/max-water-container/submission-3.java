class Solution {
    public int maxArea(int[] heights) {
        // use two pointers starting from both ends of the arr
        // since we wanna find the max area
        // so every time we move the shorter pointer inward, and update the max area if need
        int max = 0;
        int l = 0;
        int r = heights.length - 1;
        while(l < r){
            int curArea = (r - l) * Math.min(heights[l], heights[r]);
            max = Math.max(max, curArea);
            if(heights[l] < heights[r]){
                l++;
            }else{
                r--;
            }
        }
        return max;
    }
}
