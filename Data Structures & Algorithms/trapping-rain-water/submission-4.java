class Solution {
    public int trap(int[] height) {
        /*
        At each position, the water trapped equals the minimum of 
        left max and right max minus the current height.
        So I'll precompute the left max array and right max array, 
        and then iterate through the height array to calculate the total water trapped. 
        The time complexity is O(n) and the space complexity is also O(n)
        */
        // ***** TIME: O(n), SPACE:O(n) *****
        int n = height.length;
        if(n <= 1) return 0;
        
        int[] leftMax = new int[n];
        leftMax[0] = 0;
        for(int i = 1; i < n; i++){
            leftMax[i] = Math.max(leftMax[i - 1], height[i - 1]);
        }
        int[] rightMax = new int[n];
        rightMax[n - 1] = 0;
        for(int i = n - 2; i >= 0; i--){
            rightMax[i] = Math.max(rightMax[i + 1], height[i + 1]);
        }

        int res = 0;
        for(int i = 1; i < n - 1; i++){
            res += Math.max(Math.min(leftMax[i], rightMax[i]) - height[i], 0);
        }
        return res;




        

        // ***** TIME: O(n), SPACE:O(1) *****
        // Two Pointers + Greedy
        // 用 l, r指针 + leftMax, rightMax四个变量记录
        /*
        Instead of storing prefix and suffix arrays, we can use two pointers with two variables 
        tracking the current leftMax and rightMax.
        At each step we move the pointer with the smaller height, 
        because the trapped water is limited by the smaller boundary.
        */
        // int l = 0, r = height.length - 1;
        // int leftMax = 0, rightMax = 0;
        // int res = 0;
        // while(l < r){
        //     if(height[l] < height[r]){
        //         leftMax = Math.max(height[l], leftMax);
        //         res += leftMax - height[l++];
        //     }else{
        //         rightMax = Math.max(height[r], rightMax);
        //         res += rightMax - height[r--];
        //     }
        // }
        // return res;
    }
}
