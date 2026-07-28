class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for(int pile : piles) {
            max = Math.max(max, pile);
        }
        int l = 1;
        int r = max;
        while(l <= r) {
            int mid = l + (r - l) / 2;
            int t = getTime(piles, mid);
            if(t > h) {
                l = mid + 1;
            }else {
                r = mid - 1;
            }
        }
        return l;
    }
    private int getTime(int[] piles, int k) {
        int t = 0;
        for(int pile : piles) {
            t += pile / k;
            if(pile % k != 0) {
                t++;
            }
        }
        return t;
    }
}
