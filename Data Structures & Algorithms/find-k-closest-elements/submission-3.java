class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        if (k >= arr.length) return Arrays.stream(arr).boxed().toList();
        int r = k, l = 0;
        for(; r < arr.length; r++) {
            if (x - arr[l] > arr[r] - x) {
                l++;
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = l; i < l + k; i++) {
            res.add(arr[i]);
        }
        return res;
    }
}