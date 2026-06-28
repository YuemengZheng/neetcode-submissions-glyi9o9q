class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        // 这个题目用sliding window更加合适，因为天然的有序，不然我们最后还要排序
        // use binary search to find the the most closest integer to x
        // use two pointers starts from there and expand outwards to find k closest elements
        int mid = findTarget(arr, x);
        int l = mid;
        int r = mid + 1;
        List<Integer> res = new ArrayList<>();
        while(k > 0){
            // // 直接给leftNum赋值，不是lpointer，不然后面arr[l]还要写的
            // int leftNum = l < 0 ? Integer.MAX_VALUE : arr[l];
            // int rightNum = r >= arr.length ? Integer.MAX_VALUE : arr[r];
            // if(Math.abs(leftNum - x) <= Math.abs(rightNum - x)){ // 跟x做比较不是arr[mid]
            //     res.add(leftNum);
            //     l--;
            // }else{
            //     res.add(rightNum);
            //     r++;
            // }
            // k--;
            if(l < 0){
                res.add(arr[r++]);
            }else if(r >= arr.length){
                res.add(arr[l--]);
            }else if(x - arr[l] <= arr[r] - x){
                res.add(arr[l--]);
            }else{
                res.add(arr[r++]);
            }
            k--;
        }
        // 要求返回ascending order
        Collections.sort(res);
        return res;
    }
    private int findTarget(int[] arr, int target){
        int l = 0;
        int r = arr.length - 1;
        while(l <= r){
            int mid = l + (r - l) / 2;
            if(arr[mid] == target){
                return mid;
            }else if(arr[mid] > target){
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        if(l == arr.length) return r;
        if(r == -1) return l;
        return arr[l] - target <= target - arr[r] ? l : r;
    }
}