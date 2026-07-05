/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        // find the peak, so left is increasing right is decreasing
        int peak = getPeak(mountainArr);
        if(mountainArr.get(peak) == target) return peak;
        int res = findTarget(mountainArr, target, true, 0, peak - 1);
        if(res == -1){
            res = findTarget(mountainArr, target, false, peak + 1, mountainArr.length() - 1);
        }
        return res;
    }
    private int getPeak(MountainArray mountainArr) {
        int l = 0;
        int r = mountainArr.length() - 1;
        while(l <= r) {
            int mid = l + (r - l) / 2;
            if(mountainArr.get(mid - 1) < mountainArr.get(mid)){
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }
        return r;
    }
    private int findTarget(MountainArray mountainArr, int target, boolean ascending, int l, int r){
        while(l <= r){
            int mid = l + (r - l) / 2;
            int cur = mountainArr.get(mid);
            if(cur == target){
                return mid;
            }
            if(ascending){
                if(cur < target){
                    l = mid + 1;
                }else{
                    r = mid - 1;
                }
            }else{
                if(cur < target){
                    r = mid - 1;
                }else{
                    l = mid + 1;
                }
            }
        }
        return -1;
    }

}