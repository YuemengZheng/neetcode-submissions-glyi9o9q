class Solution {
    /*
    For the container with most water, 
    the area depends on the width and the shorter height.
    So I use two pointers starting from both ends — 
    this way I can maximize the width. 
    Then I'll move inward to find larger areas. 
    Since moving inward decreases the width, 
    the only way to get a larger area is to find a taller height. 
    So I'll move the pointer with the shorter height inward, 
    hoping to find a taller height. 
    And I'll keep track of the maximum area.
    */
    // tc: o(n), sc:o(1)
    public int maxArea(int[] heights) {
        int l = 0, r = heights.length - 1;
        int maxArea = 0;
        while(l < r){
            int area = Math.min(heights[l], heights[r]) * (r - l);
            maxArea = Math.max(maxArea, area);
            if(heights[l] < heights[r]){
                l++;
            }else{
                r--;
            }
        }
        return maxArea;
    }
}
