class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = 1000000000;
        while(l <= r){
            int mid = l + (r - l) / 2;
            int time = getTime(mid, piles);
            if(time > h){
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }
        return l;
    }
    // getTime -> get the total time needed to eat all piles
    private int getTime(int v, int[] piles){
        int res = 0;
        for(int pile : piles){
            res += pile / v;
            if(pile % v > 0){
                res++;
            }
        }
        return res;
    }
}
