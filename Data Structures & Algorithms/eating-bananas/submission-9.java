class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // k和时间的关系是负向的，k越小时间越大，但是时间最大是h
        // 在k上面binary search，找到一个速度，计算得到的时间是小于h的最大值
        int maxK = 0;
        for(int pile : piles){
            maxK = Math.max(maxK, pile);
        }

        int l = 1;
        int r = maxK;
        while(l <= r){
            int mid = l + (r - l) / 2;
            int t = getTime(mid, piles);
            if(t > h){
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }
        return l;
    }
    private int getTime(int v, int[] piles){
        int res = 0;
        for(int pile : piles){
            res += pile / v;
            if(pile % v > 0){
                res += 1;
            }
        }
        return res;
    }
}
