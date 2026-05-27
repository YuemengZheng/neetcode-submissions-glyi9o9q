class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // // ***** TIME: O(log(min(m, n))), SPACE:O(1) *****
        /*
        Since both arrays are sorted, we can think of them as one combined sorted array.
        The median splits the array into two equal halves, so our goal is to find a partition where:    
            the number of elements on the left side equals the number on the right side (or differs by one),
            and every element in the left partition is smaller than or equal to every element in the right partition.
        we can use binary search to find the correct partition.
        */
        if(nums1.length <= nums2.length){
            return helper(nums1, nums2);
        }else{
            return helper(nums2, nums1);
        }  
    }
    public double helper(int[] a, int[] b){
        int n = a.length;
        int m = b.length;
        int half = (n + m + 1) / 2;
        // use binary search to find the cutting position in the array1(切给左边0个或者n个)
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
