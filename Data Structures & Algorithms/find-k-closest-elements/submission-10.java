class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        // binary search
        // find the range of starts
        // apply binary search to that range
        // for each mid element:
        // if target - arr[mid] > arr[mid + k] - target => move r to mid - 1
        // else move l to mid
        // return the k sized arr starting from l
        int l = 0;
        int r = arr.length - k;
        while(l < r) {
            int mid = l + (r - l) / 2;
            if(Math.abs(x- arr[mid]) <= Math.abs(x - arr[mid + k])) {
                r = mid;
            }else {
                l = mid + 1;
            }
        }
        List<Integer> res = new ArrayList<>();
        while(k > 0) {
            res.add(arr[l++]);
            k--;
        }
        return res;
    }
}