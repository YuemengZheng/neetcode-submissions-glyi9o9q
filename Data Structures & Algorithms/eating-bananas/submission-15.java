class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // get the k range 
        // k 与 time 的关系是相反的， 所以我们用二分找到k，计算时间和h做对比
        int l = 1;
        int r = 0;
        for(int pile : piles) {
            r = Math.max(pile, r);
        }
        while(l <= r) {
            int mid = l + (r - l) / 2;
            int time = getTime(piles, mid);
            if(time <= h) {
                r = mid - 1;
            }else {
                l = mid + 1;
            }
        }
        return l;
    }
    private int getTime(int[] piles, int k) {
        int res = 0;
        for(int pile : piles) {
            res += (pile + k - 1) / k;
        }
        return res;
    }
}
