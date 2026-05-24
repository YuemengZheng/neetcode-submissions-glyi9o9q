class Solution {
    /*
    I use a two-pointer approach starting from both ends of the array to maximize the width.
    Since the area is limited by the shorter height, 
    I move the pointer with the smaller height inward to 
    potentially find a taller boundary and a larger area
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
