class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        /*
        since the arr is sorted, so i will use two pointers starting from both ends of the arr,
        repeatedly remove whichever element is further away from the target x, so the final remaining elments are the closest ones
        */
        int l = 0;
        int r = arr.length - 1;
        while(r > l + k - 1){
            if(Math.abs(x - arr[l]) > Math.abs(x - arr[r])){
                l++;
            }else{
                r--;
            }
        }
        List<Integer> res = new ArrayList<>();
        for(int i = l; i <= r; i++) {
            res.add(arr[i]);
        }
        return res;
    }
}