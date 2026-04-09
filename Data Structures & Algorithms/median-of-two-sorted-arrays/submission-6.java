class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // // ***** TIME: O(log(min(m, n))), SPACE:O(1) *****
        // Binary search to find the correct partition
        // 如何把两个数组视作一个整体，我们各自切一刀
        // 使得整体左边的个数 >= 右边的个数 && 所有左边的数字 <= 右边的数字
        // 现在转换问题为怎么切两个数组满足以上的条件
        // 我们可以先大致切一刀保证个数准确，然后移动保证分类准确
        // 我们先在较短的数组上二分切分位置
        // 如果 nums1 长度是 m，那么切法有 0 到 m，共 m + 1 种
        // 假设在 nums1 中左边取 i 个元素，那么为了保证左半部分总数正确，
        // nums2 中左边必须取 j = leftSize - i 个元素

        // 然后检查当前 partition 是否合法：
        // nums1 左边最大值 <= nums2 右边最小值
        // nums2 左边最大值 <= nums1 右边最小值
        // 也就是：Aleft <= Bright && Bleft <= Aright
        if(nums1.length <= nums2.length){
            return helper(nums1, nums2);
        }else{
            return helper(nums2, nums1);
        }  
    }
    public double helper(int[] a, int[] b){
        // int n = a.length;
        // int m = b.length;
        // int half = (n + m + 1) / 2;
        // // 用binary search 去不断找到符合条件的切分点
        // int l = 0, r = n;
        // while(l <= r){
        //     int i = l + (r - l) / 2;
        //     int j = half - i;

        //     // 测试切分的对不对
        //     int Aleft = i > 0 ? a[i - 1] : Integer.MIN_VALUE;
        //     int Bleft = j > 0 ? b[j - 1] : Integer.MIN_VALUE;
        //     int Aright = i < n ? a[i] : Integer.MAX_VALUE;
        //     int Bright = j < m ? b[j] : Integer.MAX_VALUE;

        //     if(Aleft <= Bright && Bleft <= Aright){
        //         // 基数
        //         if((n + m) % 2 != 0){
        //             return Math.max(Aleft, Bleft);
        //         }
        //         // 偶数
        //         else{
        //             return (Math.max(Aleft, Bleft) + Math.min(Bright, Aright)) / 2.0;
        //         }
        //     }else if(Aleft > Bright){
        //         r  = i - 1;
        //     }else{
        //         l = i + 1;
        //     }
        // }
        // return -1;

        int n = a.length;
        int m = b.length;
        int half = (n + m + 1) / 2;
        // use binary search to find the cutting position in the array1
        int left = 0, right = n;
        while(left <= right){
            int i = left + (right - left) / 2;
            int j = half - i;
    
            int Aleft = i > 0 ? a[i - 1] : Integer.MIN_VALUE;
            int Aright = i < n ? a[i] : Integer.MAX_VALUE;
            int Bleft = j > 0 ? b[j - 1] : Integer.MIN_VALUE;
            int Bright = j < m ? b[j] : Integer.MAX_VALUE;

            if(Aleft <= Bright && Bleft <= Aright){
                if((n + m) % 2 != 0){
                    return Math.max(Aleft, Bleft);
                }else{
                    return (Math.max(Aleft, Bleft) +  Math.min(Aright, Bright)) / 2.0;
                }
            }else if(Aleft > Bright){
                right = i - 1;
            }else{
                left = i + 1;
            }
        }
        return -1;
    }
}
