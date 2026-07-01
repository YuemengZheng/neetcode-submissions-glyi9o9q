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
        // 首先找顶峰，这样我们才可以分辨sorted
        // 没有顶峰作为分界点，你就无法确定有序区间，binary search 就没有方向
        int peak = findPeak(mountainArr);
        if(mountainArr.get(peak) == target) return peak;
        int res = findTarget(mountainArr, target, 0, peak - 1, true);
        if(res != -1) return res;
        return findTarget(mountainArr, target, peak + 1, mountainArr.length() - 1, false);
    }
    private int findPeak(MountainArray mountainArr){
        int l = 0;
        int r = mountainArr.length() - 1;
        while(l <= r){
            int mid = l + (r - l) / 2;
            if(mountainArr.get(mid) > mountainArr.get(mid + 1)){
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        return l;
    }
    private int findTarget(MountainArray mountainArr, int target, int l, int r, boolean ascending){
        while(l <= r){
            int mid = l + (r - l) / 2;
            if(mountainArr.get(mid) == target){
                return mid;
            }
            if(ascending){
                if(mountainArr.get(mid) < target){
                    l = mid + 1;
                }else{
                    r = mid - 1;
                }
            }else{
                if(mountainArr.get(mid) > target){
                    l = mid + 1;
                }else{
                    r = mid - 1;
                }
            }
        }
        return -1;
    }
}