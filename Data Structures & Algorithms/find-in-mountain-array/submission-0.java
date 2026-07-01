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
        int peakIndex = findPeak(mountainArr);
        if(mountainArr.get(peakIndex) == target) return peakIndex;
        // find target in the left
        int l = 0;
        int r = peakIndex - 1;
        while(l <= r){
            int mid = l + (r - l) / 2;
            if(mountainArr.get(mid) == target) return mid;
            else if(mountainArr.get(mid) < target){
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }

        // find target in the right
        l = peakIndex + 1;
        r = mountainArr.length() - 1;
        while(l <= r){
            int mid = l + (r - l) / 2;
            if(mountainArr.get(mid) == target) return mid;
            else if(mountainArr.get(mid) < target){
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        return -1; 
    }
    private int findPeak(MountainArray mountainArr){
        int l = 0;
        int r = mountainArr.length() - 1;
        while(l <= r){
            int mid = l + (r - l) / 2;
            if(mountainArr.get(mid) > mountainArr.get(mid - 1) && mountainArr.get(mid) > mountainArr.get(mid + 1)){
                return mid;
            }else if(mountainArr.get(mid) > mountainArr.get(mid - 1) && mountainArr.get(mid) < mountainArr.get(mid + 1)){
                l = mid + 1;
            }else {
                r = mid - 1;
            }
        }
        return -1;
    }
}