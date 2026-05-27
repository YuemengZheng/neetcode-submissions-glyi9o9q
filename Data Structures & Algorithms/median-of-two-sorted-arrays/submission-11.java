class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // median是要将数据平分，然后根据基数和偶数得到median
        // 因为两个list是sorted，所以我们可以将他们视为一个整体
        // 用binary search尝试去将他们分为两部分数量差不多的，但是需要保证num1右边比num2的左边大，nums2的右边比num1的左边大
        // 然后根据情况移动
        int len1 = nums1.length;
        int len2 = nums2.length;
        if(len1 < len2){
            return helper(nums1, nums2);
        }
        return helper(nums2, nums1);
    }
    private double helper(int[] nums1, int[] nums2){
        int totalLen = nums1.length + nums2.length;
        int leftHalf = (totalLen + 1) / 2;
        int left = 0;
        int right = nums1.length;
        while(left <= right){
            int leftNums1 = left + (right - left) / 2;
            int leftNums2 = leftHalf - leftNums1;

            int left1 = leftNums1 > 0 ? nums1[leftNums1 - 1] : Integer.MIN_VALUE;
            int left2 = leftNums2 > 0 ? nums2[leftNums2 - 1] : Integer.MIN_VALUE;
            int right1 = leftNums1 < nums1.length ? nums1[leftNums1] : Integer.MAX_VALUE;
            int right2 = leftNums2 < nums2.length ? nums2[leftNums2] : Integer.MAX_VALUE;

            if(left1 <= right2 && left2 <= right1){
                if(totalLen % 2 == 1){
                    return Math.max(left1, left2);
                }else{
                    return (Math.max(left1, left2) + Math.min(right1, right2)) / 2.0;
                }
            }else if(left1 > right2){
                right = leftNums1 - 1;
            }else{
                left = leftNums1 + 1;
            }
        }
        return -1;
    }
}

