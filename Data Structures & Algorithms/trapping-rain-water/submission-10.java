class Solution {
    public int trap(int[] height) {
        int res = 0;
        int leftMax = 0;
        int rightMax = 0;
        int l = 0;
        int r = height.length - 1;
        while(l <= r){
            if(leftMax < rightMax){
                res += Math.max(leftMax - height[l], 0);
                leftMax = Math.max(leftMax, height[l]);
                l++;
            }else{
                res += Math.max(rightMax - height[r], 0);
                rightMax = Math.max(rightMax, height[r]);
                r--;
            }
        }
        return res;
    }
}
